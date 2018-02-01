/**
BFS的简单应用。
**/

class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int max_area = 0;
        for(int i = 0; i < grid.size(); ++i) {
            for(int j = 0; j < grid[i].size(); ++j) {
                if(grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    if(area > max_area) max_area = area;
                }
            }
        }
        return max_area;
    }
private:
    int bfs(vector<vector<int>>& grid, int i, int j) {
        queue<pair<int, int>> q;
        grid[i][j] = 2;
        q.push(make_pair(i, j));
        int area = 0;
        int cur_row;
        int cur_col;
        while(!q.empty()) {
            cur_row = q.front().first;
            cur_col = q.front().second;
            area++;
            if(cur_row - 1 >= 0 && grid[cur_row - 1][cur_col] == 1) {
                grid[cur_row - 1][cur_col] = 2;
                q.push(make_pair(cur_row - 1, cur_col));
            }
            if(cur_col - 1 >= 0 && grid[cur_row][cur_col - 1] == 1) {
                grid[cur_row][cur_col - 1] = 2;
                q.push(make_pair(cur_row, cur_col - 1)); 
            }
            if(cur_row + 1 < grid.size() && grid[cur_row + 1][cur_col] == 1) {
                grid[cur_row + 1][cur_col] = 2;
                q.push(make_pair(cur_row + 1, cur_col)); 
            }
            if(cur_col + 1 < grid[cur_row].size() && grid[cur_row][cur_col + 1] == 1) {
                grid[cur_row][cur_col + 1] = 2;
                q.push(make_pair(cur_row, cur_col + 1)); 
            }
            q.pop();
        }
        return area;
    }
};
