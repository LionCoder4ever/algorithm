/*
 * @lc app=leetcode.cn id=461 lang=cpp
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
public:
    int hammingDistance(int x, int y) {
        int n = x ^ y;
        int ans = 0;
        while (n != 0) {
            n = n & (n-1);
            ans++;
        }
        return ans;
    }
};
// @lc code=end

