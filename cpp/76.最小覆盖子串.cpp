/*
 * @lc app=leetcode.cn id=76 lang=cpp
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution
{
public:
    string minWindow(string s, string t)
    {
        unordered_map<char,int> tmap;
        unordered_map<char,int> smap;
        for (auto item: t) {
            tmap[item]++;
        }
        int cur = 0;
        int need = tmap.size();
        int l = 0, r = 0;

        int ans = INT_MAX;
        int ansl = 0;

        while(r < s.size()) {
            auto c = s[r];
            smap[c]++;
            if (tmap.find(c) != tmap.end() && tmap[c] == smap[c]) {
                cur++;
            }

            while(cur == need) {
                if (r-l+1 < ans) {
                    ans = r-l+1;
                    ansl = l;
                }
                smap[s[l]]--;
                if (tmap.find(s[l]) != tmap.end() && smap[s[l]] < tmap[s[l]]) {
                    cur--;
                }
                l++;
            }
            r++;
        }
        return ans == INT_MAX ? "" : s.substr(ansl, ans);
    }
};
// @lc code=end
