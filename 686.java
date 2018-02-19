/**
记A*为A不断重复的一个无穷长的串，问题就可以转化成在A*中找B的字符串匹配问题。
实际上A*并不是无穷长的，如果B是A*的一个子串，那么B一定是A的后缀+A的若干重复+A的前缀这种组合。当把B的前缀和后缀分别补全成A后，
增加的长度不会超过两个A的长度，所以A*的长度等于B的长度加两个A的长度就足以求解了。举个例子，A="abcd"，B="dabcda"，A*="abc dabcda bcd"。

实现的时候，要注意A是不断重复的，所以匹配串下标要取模。
**/

class Solution {
    private int[] generateNext(String s) {
        int[] next = new int[256];
        for (int i = 0; i < 256; ++i) {
            next[i] = -1;
        }
        for (int i = 0; i < s.length(); ++i) {
            next[(int) s.charAt(i)] = i;
        }
        return next;
    }

    public int repeatedStringMatch(String A, String B) {
        if (0 == A.length() || 0 == B.length()) return -1;

        int[] next = generateNext(B);
        final int maxALength = (B.length() / A.length() + 2) * A.length();
        for (int start_index = 0; start_index < maxALength; ) {
            int i = start_index, j = 0;
            while (j < B.length() && A.charAt(i % A.length()) == B.charAt(j)) {
                i++;
                j++;
            }

            //start_index + B.length()就是B补全前缀后的长度，这个补全的串里只有若干重复的A和一个可能存在的需要补全的A的前缀。
            if (B.length() == j)
                return (start_index + B.length()) / A.length() + ((start_index + B.length()) % A.length() == 0 ? 0 : 1);

            if (start_index + B.length() < maxALength) {
                start_index += (B.length() - next[(int) A.charAt((start_index + B.length()) % A.length())]);
            } else {
                return -1;
            }
        }

        return -1;
    }
}
