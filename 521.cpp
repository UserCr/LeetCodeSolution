/**
垃圾题目，题意不清。
实际上题目并没有要求子串运算，比如"abcd"和"abef"，它们的非公共长度是4而不是2。
因此这个题只要两个字符串一致，一定是-1，不一致的话一定是比较长的串的长度。
**/

class Solution {
public:
    int findLUSlength(string a, string b) {
        return a == b ? -1 : max(a.size(), b.size());
    }
};
