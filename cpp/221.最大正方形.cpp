/*
 * @lc app=leetcode.cn id=221 lang=cpp
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int row = matrix.size();
        int col = matrix[0].size();
        vector<vector<int>> dp(row, vector<int>(col));
        // 初始化边界
        for(int i=0;i<col;i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        for(int i=0;i<row;i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
        }

        int ans = 0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if (matrix[i][j] == '1') {
                    if (i!=0 && j !=0) {
                        dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    ans = max(ans, dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
};
// @lc code=end

