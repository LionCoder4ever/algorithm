/*
 * @lc app=leetcode.cn id=215 lang=cpp
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        // 默认大顶堆
        priority_queue<int> q;
        for (int i=0;i<nums.size();i++) {
            q.push(nums[i]);
        }
        int ans = 0;
        for(int i=1;i<1e4 + 1;i++) {
            if (i == k) {
                ans = q.top();
            }
            q.pop();
        }
        return ans;
    }
};
// @lc code=end

