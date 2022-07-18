/*
 * @lc app=leetcode.cn id=438 lang=cpp
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> ans;
        
        unordered_map<int, int> map;
        for (auto c : p) {
            map[c-'a']++;
        }

        for(int l =0, r=0; r < s.size();r++) {
            map[s[r] - 'a']--;
            while(map[s[r] - 'a'] < 0) {
                map[s[l] - 'a']++;
                l++;
            }
            if ( r- l + 1 == p.size()) {
                ans.push_back(l);
            }
        }
        return ans;
    }
};
// @lc code=end

