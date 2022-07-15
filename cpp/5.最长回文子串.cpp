/*
 * @lc app=leetcode.cn id=5 lang=cpp
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
public:
    string longestPalindrome(string s) {
        int ansl = 0, ans = 0;
        int n = s.size();

        // 中心法
        // aba 可以取得中心值得所有情况为
        // a (0,0)
        // b (1,1)
        // c (2,2)
        // ab (0,1)
        // ba (1,2)
        for (int i=0;i<2 * n -1;i++) {
            int l = i / 2;
            int r = l + i % 2;
            while(l >= 0 && r < n && s[l] == s[r]) {
                if (r -l + 1 > ans) {
                    ans = r-l +1;
                    ansl = l;
                }
                l--;
                r++;
            }
        }
        return s.substr(ansl, ans);
    }
};
// @lc code=end

