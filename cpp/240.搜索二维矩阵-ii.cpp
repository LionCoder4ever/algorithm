/*
 * @lc app=leetcode.cn id=240 lang=cpp
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix[0].size();
        for(int i=0;i<matrix.size();i++) {
            bool res = bsearch(matrix[i], 0, n, target);
            if (res) return true;
        }
        return false;
    }

    int bsearch(vector<int>& v, int l, int r, int target)
    {
        while (l < r)
        {
            int mid = l + r >> 1;
            if (v[mid] >= target)  r= mid;    // check()判断mid是否满足性质
            else l = mid + 1;
        }
        if (l>=v.size()) return false;
        return v[l] == target;
    }
};
// @lc code=end

