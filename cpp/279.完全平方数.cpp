/*
 * @lc app=leetcode.cn id=279 lang=cpp
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
public:
    int numSquares(int n) {
        vector<int> f(n+1);

        for(int i=1;i<=n;i++) {
            int ans = INT_MAX;
            for(int j=1;j*j<=i;j++) {
                ans = min(ans, f[i-j*j]);
            }
            f[i] = ans+1;
        }
        return f[n];
    }
};
// @lc code=end

