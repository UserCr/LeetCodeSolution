/**
公共字符串匹配问题，KMP，BM或Sunday算法均可。这里用的是Sunday算法。
KMP算法理解起来有一些困难，可以参考https://www.cnblogs.com/zhangtianq/p/5839909.html这篇文章，不过作者在解释求next数组的时候，
思路上绕了一些不必要的弯路，其实这一过程等同于对模式串自身做一次公共字符串匹配，并将相关结果记录成next数组。下边简单记录一下我对于KMP算法的理解。
最基础的暴力算法是正确的，但它会在匹配失败时将两个数组下标回退太多，导致反复匹配已检查过的字符串，浪费时间，因此我们希望算法能够记录之前的结果，
直接从不一致的地方开始匹配，避免重复工作。
为了方便理解，举几个例子（注：字符串里没有空格，空格是为了突出要匹配的字符）：
case1：s = "abcab c abd", p = "abcab d ", i = j = 5。p[j] != s[i], 显然从直观上我们发现这时如果j能从5一下子变成2，是最理想的。
case2: s = "ab s abc", p = "ab c "，显然从直观上我们希望这时j能一下子变成0，同时i++。
case3: s = " a bc", p = " b c"，模式串的第一个字符就不匹配，显然继续匹配下去毫无意义，所以这时最好的办法就是i++，直接跳过当前字符。 
从case1, case2可以看出，如果在失配的时候j能一下子变成理想值，就会省不少事。现在我们不妨假设有一个神奇数组next，里边存储的全部都是j对应的理想下标。
一旦匹配失败，就执行j = next[j]。
public int strStr(String haystack, String needle) {
    if (0 == needle.length()) return 0;  //leetcode上题目要求模式串为空串时要返回0，有的题目可能要求返回-1，具体情况具体分析。
    
    int[] next = generateNext(needle);
    int i = 0, j = 0;
    while (i < haystack.length() && j < needle.length()) {
        if (haystack.charAt(i) == needle.charAt(j)) {
            //如果匹配成功，当然要i++，j++去匹配下个字符。
            i++;
            j++;
        } else if (0 == j) {
            //这里对应的是case3
            i++;
        } else {
            //发生失配，暴力算法中这里要把j回退成0，i回退成匹配前的状态。这里直接把j变成理想值，提高了效率。
            //值得一提的是case2中需要i++，但是因为还存在next[0] == haystack[i]的情况，所以i++不能在这里执行，
            //而是要等到下个循环判断是否相等后再决定后续操作。
            j = next[j];
        }
    }
    
    if (needle.length() == j) return i - j;
    
    return 0;
}
上述代码是容易理解的，关键是求出神奇数组next。

在求出神奇数组next前，需要先解释清楚next数组的内容会不会随着匹配串的变化而变化。实际上，对于匹配串中失配的部分，我们的做法是直接跳过，也就是case3。
因为不匹配部分有一些子串是模式串中不存在的，所以无论怎么用模式串去匹配失配部分，都不可能成功，因此即便以后遇到失配，下标也不可能回退到失配部分，
否则就会增加不必要的工作。由此可知，next数组与失配部分是无关的。对于已经匹配过的部分，因为匹配串和模式串都是一样的，
所以完全可以认为next数组只和模式串有关。

记模式串为p，如果我们已经知道p[0-j]和p[?-i](i>j, ? = i-j)是匹配的，那么当p[i+1]与匹配串的某个字符失配时，就可以让匹配串从p[j+1]处开始匹配，
因为这个字符之前的p[0-j]和p[?-i]是完全一样的，没有必要再匹配一次（例子见case1），所以i+1处对应的理想值就是j+1。
由此可得，当p[i] == p[j]时，next[i+1] = j+1。这也是求next数组的主要原理。不过这还不够，当模式串中不存在任何j使得p[0-j]与p[?-i]相同时，
一旦发生失配，需要让模式串从头开始匹配，即此时p[j+1]对应的理想值是0（例子见case2）。
综上，我们就得到了求next数组的全部逻辑。
下边是求next数组的代码，可以看出它和上边的代码非常相似，实际上，我们可以将这一过程理解成对模式串自身的一次公共字符串匹配。
i可以理解成匹配串下标，j可以理解成模式串的模式串下标。从求next数组的逻辑可以看出，如果我们要得到某一位的理想值，至少需要知道匹配串中该位的前一位字符，
还有模式串中的某一位字符。模式串要从头开始看，j初值自然为0。i不能和j相同，不然比较结果永远都是相同的，所以初值要为1。这也就意味着，
模式串第0位是模式串的模式串的第一个字符输入，模式串第1位是匹配串的第一个字符输入，所以生成逻辑只能从第三个理想值处开始计算，前两个理想值需要单独分析。
private int[] generateNext(String needle) {
    int[] next = new int[needle.length()];
    //如果模式串第一个字符就不匹配，当然理想值要为0。
    //如果模式串第二个字符不匹配，自然要观察不匹配字符是否能与模式串第一个字符匹配，所以理想值为0。
    next[0] = 0;
    if (needle.length() > 1) next[1] = 0;

    int i = 1, j = 0;
    while (i < needle.length() - 1) {
        if (needle.charAt(i) == needle.charAt(j)) {
            i++;
            j++;
            next[i] = j;
        } else if (0 == j) {
            //这种情况才意味着不存在p[0-j]==p[?-i]。
            i++;
            next[i] = 0;
        } else {
            //前边可能存在p[0-j]==p[?-i]，所以直接把j回退成理想值再做判断。
            j = next[j];
        }
    }
    return next;
}

以上是KMP算法的全部代码，实际上代码可以变得更加简洁高效，具体来说就是：
1.next数组中的第一位可以变成-1，这样就不用再判断j==0的情况了，不过代码会更难理解一些；
2.如果p[j] = p[next[j]]的话，s[i]!=p[j]自然使得s[i]!=p[next[j]]，所以需要调整next[j]直到p[j]!=p[next[j]]或j=0。

优化过的代码网上到处都是，自己写也很好改，不再赘述。

下边是Sunday算法，直接参考下边这篇文章即可，相当容易理解。
http://blog.csdn.net/laojiu_/article/details/50767615
**/
class Solution {
    private int[] generateNext(String needle) {
        int[] next = new int[256];
        for(int i = 0; i < next.length; ++i) {
            next[i] = -1;
        }
        for(int i = 0; i < needle.length(); ++i) {
            next[(int) needle.charAt(i)] = i;
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        if(0 == needle.length()) return 0;
        
        int[] next = generateNext(needle);
        for(int i = 0; i <= haystack.length() - needle.length();) {
            int k = i, j = 0;
            while(j < needle.length() && haystack.charAt(k) == needle.charAt(j)) {
                k++;
                j++;
            }
            if(j == needle.length()) {
                return i;
            } else {
                if(i + needle.length() < haystack.length()) {
                    i += (needle.length() - next[(int)haystack.charAt(i + needle.length())]);
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }
}
