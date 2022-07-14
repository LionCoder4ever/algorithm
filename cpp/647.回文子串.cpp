/*
 * @lc app=leetcode.cn id=647 lang=cpp
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
public:
    int countSubstrings(string s) {
        int n = s.size();

        int ans = 0;
        for (int i = 0;i < 2*n ;i++) {
            int l = i / 2;
            int r = l + i % 2;

            while((l >=0) && (r < n) && (s[l] == s[r])) {
                ans++;
                l--;
                r++;
            }
        }
        return ans;
    }
};
// @lc code=end

