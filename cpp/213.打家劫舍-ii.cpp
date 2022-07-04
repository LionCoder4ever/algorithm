/*
 * @lc app=leetcode.cn id=213 lang=cpp
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n==1) return nums[0];
        if (n==2) return max(nums[0], nums[1]);

        // 0 和 n-1 不能同时抢
        return max(rob_internal(nums, 1, n-1), rob_internal(nums, 0, n-2));
    }

    // 打劫I
    int rob_internal(vector<int>& nums, int left, int right) {
        int p1 = nums[left];
        int p2 = max(nums[left], nums[left+1]);
        int p = p2;
        for(int i=left+2;i<=right;i++) {
            p = max(p1 + nums[i], p2);
            p1 = p2;
            p2 = p;
        }
        return p;
    }
};
// @lc code=end

