/*
 * @lc app=leetcode.cn id=200 lang=cpp
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int ans = 0;
        for (int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                ans += grid[i][j] - '0';
                dfs(grid, i, j, m, n);
            }
        }
        return ans;
    }

    void dfs(vector<vector<char>>& grid, int x,int y, int m, int n) {
        if (x<0 || y<0 || x >=m || y >=n || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x-1, y, m , n);
        dfs(grid, x+1, y, m , n);
        dfs(grid, x, y-1, m , n);
        dfs(grid, x, y+1, m , n);
    }
};
// @lc code=end

