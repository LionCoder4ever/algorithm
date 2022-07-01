/*
 * @lc app=leetcode.cn id=121 lang=cpp
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int ans = INT_MIN;
        int buy = INT_MAX;
        for(int i =0;i<n;i++) {
            buy = min(buy, prices[i]);
            ans = max(prices[i]- buy, ans);
        }
        return ans;
    }
};
// @lc code=end

