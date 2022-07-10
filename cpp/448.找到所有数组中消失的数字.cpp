/*
 * @lc app=leetcode.cn id=448 lang=cpp
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans;
        for (int i=0;i<n;i++) {
            // nums[i-1] 已经被加过n, 访问会越界
            int x = (nums[i] - 1) % n;
            nums[x] += n;
        }

        for (int i=0;i<n;i++) {
            if (nums[i] <= n) {
                ans.push_back(i+1);
            }
        }
        return ans;
    }
};
// @lc code=end

