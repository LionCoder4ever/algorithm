/*
 * @lc app=leetcode.cn id=122 lang=cpp
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();

        // 不持有
        int p0 = 0;
        // 持有
        int p1 = -prices[0];

        for (int i =1;i<n;i++) {
            // 不持有
            int c0 = max(p0, prices[i] + p1);
            // 持有
            int c1 = max(p1, p0 - prices[i]);
            p0 = c0;
            p1 = c1;
        }
        return p0;
    }
    
};
// @lc code=end

