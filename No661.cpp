/**
简单的数组遍历，注意控制好边界。
**/

class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& M) {
        vector<vector<int>> result;
        for(int i = 0; i < M.size(); ++i) {
            vector<int> row;
            for(int j = 0; j < M[i].size(); ++j) {
                row.push_back(calculate(M, i, j));
            }
            result.push_back(row);
        }
        return result;
    }
private:
    int calculate(vector<vector<int>>& M, int i, int j) {
        double sum = 0;
        int count = 0;
        int row_end = i + 1 < M.size() ? i + 1 : M.size() - 1;
        int col_end;
        for(int row = (i > 0) ? i - 1 : 0; row <= row_end; ++row) {
            col_end = j + 1 < M[row].size() ? j + 1 : M[row].size() - 1;
            for(int col = (j > 0) ? j - 1 : 0; col <= col_end; ++col) {
                sum+= M[row][col];
                count++;
            }
        } 
        return (int)floor(sum / count);
    }
};
