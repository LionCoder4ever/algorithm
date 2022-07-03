/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n =  s.length();
        int ans = 0;
        int left = 0;
        int right = 0;
        unordered_map<char, int> map;

        for (int i=0;i<n;i++) {
            auto search = map.find(s[i]);
            if (search == map.end() || map[s[i]] == -1) {
                map[s[i]] = i;
                right++;
            } else {
                int preIndex = map[s[i]];
                int newLeft = ++preIndex;
                for (int j=left;j<newLeft;j++) {
                    map[s[j]] = -1;
                }
                left = newLeft;
                map[s[i]] = i;
                right++;
            } 
            ans = max(ans, right-left);
        }
        return ans;
    }
};
// @lc code=end

