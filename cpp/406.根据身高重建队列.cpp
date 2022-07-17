/*
 * @lc app=leetcode.cn id=406 lang=cpp
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
public:
    static bool cmp(vector<int> o1, vector<int> o2) {
        if (o1[0] > o2[0]) return true;
        else if (o1[0] == o2[0]) return o1[1] < o2[1];
        else return false;
    }
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        sort(people.begin(), people.end(), cmp);
        vector<vector<int>> ans;
        for (auto p: people) {
            ans.insert(ans.begin() + p[1], p);
        }
        return ans;
    }
};
// @lc code=end

