/*
 * @lc app=leetcode.cn id=309 lang=cpp
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();

        // 持有
        int p0 = -prices[0];
        // 不持有,在冷冻期
        int p1 = 0;
        // 不持有, 不在冷冻期, 第二天可以买
        int p2 = 0;
        for(int i=0;i<n;i++) {
            // 今天买, 或者没卖
            int c0 = max(p2 - prices[i], p0);
            // 今天卖出去
            int c1 = prices[i] + p0;
            // 不持有, 昨天卖了(还在冷冻期), 或者昨天之前卖了, 不在冷冻期
            int c2 = max(p1, p2);

            p0 = c0;
            p1 = c1;
            p2 = c2;
        }
        return max(p1,p2);
    }
};
// @lc code=end

