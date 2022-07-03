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
        unordered_map<char, int> map;
        int ans = 0;

        for(int i=0, j=0;i<n;i++) {
            map[s[i]] = map[s[i]] + 1;

            // abcb: 左指针移动到map['b']的value为1
            while(j <= i && map[s[i]] > 1) {
                map[s[j]] = map[s[j]] - 1;
                j++;
            }
            ans = max(ans, i - j + 1);
        }
        return ans;
    }
};
// @lc code=end

