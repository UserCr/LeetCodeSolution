/**
本题难度在于理解题意。题目意思是说给你一个数组，代表一个整数，比如说{1，2，3，4}就是1234，{9，9，9，9}就是9999，返回这个数加一后用数组表示的结果。
比如说输入是{1，2，3，4}，返回就是{1，2，3，5}，输入是{9，9，9，9}，返回就是{1，0，0，0，0}。
**/

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for(int i = digits.size() - 1; i >=0; --i) {
            digits[i] = (digits[i] + 1) % 10;
            if(digits[i] != 0) return digits;
        }
        vector<int> result(digits.size() + 1, 0);
        result[0] = 1;
        return result;
    }
};
