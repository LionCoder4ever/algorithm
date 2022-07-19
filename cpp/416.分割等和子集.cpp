/*
 * @lc app=leetcode.cn id=416 lang=cpp
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int n = nums.size();
        int sum = 0;
        for (auto i: nums) {
            sum+=i;
        }
        if (sum %2 != 0) return false;
        int target = sum / 2;

        vector<vector<int>> dp(n, vector<int>(target+1));
        dp[0][0] = false;

        for (int i=1;i<n;i++) {
            for (int j=0;j<=target;j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][target];
    }
};
// @lc code=end

