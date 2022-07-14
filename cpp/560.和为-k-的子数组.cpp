/*
 * @lc app=leetcode.cn id=560 lang=cpp
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> s(n+1);
        unordered_map<int,int> map{{0,1}};
        map[0] = 1;
        // 前缀和
        int ans = 0;
        for (int i=1;i<=n;i++) {
            s[i] = s[i-1] + nums[i-1];
            if (map.find(s[i]-k) != map.end()) {
                ans += map[s[i]-k];
            }
            map[s[i]]++;
        }
        for (auto i:s) {
            cout << i << endl;
        }
        return ans;
    }
};
// @lc code=end

