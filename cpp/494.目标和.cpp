/*
 * @lc app=leetcode.cn id=494 lang=cpp
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
public:
    int ans;
    int findTargetSumWays(vector<int>& nums, int target) {
        dfs(nums, nums.size(), 0, target);
        return ans;
    }

    void dfs(vector<int>& nums, int n, int level, int target) {
        if ((level == n) && (target == 0)) {
            ans++;
        }
        if  (level > n - 1) {
            return;
        }
        dfs(nums, n, level + 1, target - nums[level]);
        dfs(nums, n, level + 1, target + nums[level]);
    }
};
// @lc code=end

