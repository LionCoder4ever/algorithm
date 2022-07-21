/*
 * @lc app=leetcode.cn id=46 lang=cpp
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> ans;

    vector<vector<int>> permute(vector<int>& nums) {
        vector<int> t;
        dfs(nums,t);
        return ans;
    }

    void dfs(vector<int>& nums, vector<int> v) {
        if (v.size() == nums.size()) {
            vector<int> tmp;
            for (auto item: v) {
                tmp.push_back(item);
            }
            ans.push_back(tmp);
        }
        for (int i =0;i<nums.size(); i++) {
            if (find(v.begin(),v.end(), nums[i]) == v.end()) {
                v.push_back(nums[i]);
                dfs(nums, v);
                v.pop_back();
            }
        }
    }
};
// @lc code=end

