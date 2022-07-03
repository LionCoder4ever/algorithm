/*
 * @lc app=leetcode.cn id=322 lang=cpp
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        vector<int> dp(amount+1);
        dp[0] = 0;
        for (int i=1;i<=amount;i++) {
            // 不要越界
            int tmp = INT_MAX - 1;
            for (int j=0;j<n;j++) {
                // [2]  amount = 3
                // f[0] = 0, f[1] = INT_MAX, f[2] = 1
                // f[3] = min( f[1] , INT_MAX-1)
                if (i - coins[j] >= 0) {
                    tmp = min(tmp,dp[i-coins[j]]);
                }
            }
            dp[i] = tmp + 1;
            cout << dp[i] << endl;
        }
        return dp[amount] == INT_MAX  ? -1 : dp[amount];
    }
};
// @lc code=end

