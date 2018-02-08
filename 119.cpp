/**
把杨辉三角用数组方式对齐，一行一行写出来，很容易想到从后往前逐渐求解的办法。
**/

class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> result(rowIndex + 1, 0);
        
        result[0] = 1;
        for(int row = 1; row <= rowIndex; ++row) {
            result[row] = 1;
            for(int i = row - 1; i > 0; i--) {
                result[i] += result[i - 1];
            }
        }
        return result;
    }
};
