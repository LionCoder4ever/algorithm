/*
 * @lc app=leetcode.cn id=198 lang=cpp
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        int q_2 = 0, q_1 =0, ans = 0;
        // ans记录从当前位置开始, 能获取到的最大金额(不触发警报, 最少要跳1格)
        for (int i=n-1;i>=0;i--) {
            ans = max(q_1, nums[i] + q_2);
            q_2 = q_1;
            q_1 = ans;
        }
        return ans;
    }
};
// @lc code=end

