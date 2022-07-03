/*
 * @lc app=leetcode.cn id=338 lang=cpp
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
public:
    vector<int> countBits(int n) {

        vector<int> ans;
        for(int i=0;i<=n;i++) {
            int m = i;
            int count = 0;
            while(m) {
                m = m & (m-1);
                count++;
            }
            ans.push_back(count);
        }
        return ans;
    }
};
// @lc code=end

