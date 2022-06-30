/*
 * @lc app=leetcode.cn id=300 lang=cpp
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n+1, 0);

        for (int i=0;i<n;i++) {
            dp[i] = 1;

            for (int j=0;j<i;j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[j]+1, dp[i]);
                }
            }
        }
        int ans = INT_MIN;
        for(int i=0;i<n+1;i++) {
            ans = max(dp[i], ans);
        }
        return ans;
    }
};
// @lc code=end

