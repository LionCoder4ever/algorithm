/*
 * @lc app=leetcode.cn id=581 lang=cpp
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        if (is_sorted(nums.begin(), nums.end())) return 0;

        vector<int> sorted;
        sorted.assign(nums.begin(), nums.end());
        sort(sorted.begin(), sorted.end());
        int l = 0, r = nums.size() - 1;
        while(nums[l] == sorted[l]) {
            l++;
        }
        while(nums[r] == sorted[r]) {
            r--;
        }
        return r - l + 1;
    }
};
// @lc code=end

