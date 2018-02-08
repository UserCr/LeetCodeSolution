/**
水题
**/
class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
        int origin_row = nums.size(), origin_col = nums[0].size();
        
        if(origin_row * origin_col != r * c) return nums;
        
        vector<vector<int>> result;
        int i = 0, j = 0;
        for(int row_count = 0; row_count < r; ++row_count) {
            vector<int> row;
            int col_count = 0;
            while(col_count < c) {
                row.push_back(nums[i][j++]);
                if(j == origin_col) {
                    i++;
                    j = 0;
                }
                col_count++;
            }
            result.push_back(row);
        }
        return result;
    }
};
