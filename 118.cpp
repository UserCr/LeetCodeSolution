/**
注意特殊输入numRows为0或为1。
**/

class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> result;
        for(int i = 0; i < numRows; ++i) {
            vector<int> row = {1};
            for(int j = 0; j < i - 1; j++) {
                row.push_back(result[i - 1][j] + result[i - 1][j + 1]);
            }
            if(i > 0) row.push_back(1);
            result.push_back(row);
        }
        return result;
    }
};
