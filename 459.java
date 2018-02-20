/**
Solution1:
将所有长度能够整除原字符串长度的子串全部找出来，从长到短一个一个去试。情况比较理想的时候把原数组遍历一遍就能得到结果，情况比较特殊的话，需要遍历数遍。
class Solution {
    private LinkedList generateSubstringLength(int length) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < length; ++i) {
            if (length % i == 0) list.push(i);
        }
        return list;
    }

    private boolean isRepeatedSubstring(String s, int substringLength) {
        for (int i = 0; i < substringLength; ++i) {
            int j = i + substringLength;
            while (j < s.length()) {
                if (s.charAt(i) == s.charAt(j)) {
                    j += substringLength;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {
        LinkedList<Integer> linkedList = generateSubstringLength(s.length());
        for (int i : linkedList) {
            if (isRepeatedSubstring(s, i)) return true;
        }
        return false;
    }
}
Solution2：
KMP算法的应用。
关于KMP算法简化版理解可见 https://github.com/UserCr/LeetCodeSolution/blob/master/28.java
KMP算法核心原理是模式串中x位前缀和x位后缀是相同的。当匹配后缀的时候，也相当于同时匹配了前缀，一旦失配，已经匹配过多少位后缀，就等同于匹配过多少位前缀，
因此只要把下标回退到前缀相应位置即可，从而节约了暴力算法中再次匹配前缀中相同部分的时间。next数组只是在此基础上求出了每一位的理想下标。
理想下标其实就是相同前缀的后一位，所以它也反映了字符串中相同前缀后缀的长度。只要把求next数组的代码稍加改造，就能知道字符串相同前缀后缀的最长长度。
**/

class Solution {
    //这里要深刻理解next数组的内容。下边的方法是在线算法，每读进一个字符就会求出以该字符为结尾的字符串的前缀后缀相同长度，
    //所以next[5]=2意思是说字符串前六位的子串里相同前缀后缀长度是2。
    private int[] generateLongestPrefix(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;

        for (int i = 1, j = 0; i < s.length(); ) {
            if (s.charAt(i) == s.charAt(j)) {
                next[i++] = ++j;
            } else if (0 == j) {
                next[i++] = 0;
            } else {
                j = next[j - 1];
            }
        }

        return next;
    }

    public boolean repeatedSubstringPattern(String s) {
        int[] longestPrefix = generateLongestPrefix(s);
        //repeatedSunffixLength指的是与前缀相同的后缀的最长长度，该后缀就是剩余部分若干次重复后的子串。举两个例子：
        //“abaa”的next数组是“0011”，“a”是“aba”重复一次后的子串。
        //"abaabaaba"的next数组是“001123456”，“abaaba”是“aba”重复两次的子串。
        int repeatedSuffixLength = longestPrefix[longestPrefix.length - 1];
        return repeatedSuffixLength > 0 && s.length() % (s.length() - repeatedSuffixLength) == 0;
    }
}
