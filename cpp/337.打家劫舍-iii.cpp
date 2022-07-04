/*
 * @lc app=leetcode.cn id=337 lang=cpp
 *
 * [337] 打家劫舍 III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    unordered_map<TreeNode*, int> map;
public:
    int rob(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        if (map.count(root)) {
            return map[root];
        }

        int steal = root->val + (root->left == NULL ? 0 : rob(root->left->left) + rob(root->left->right))
        + (root->right == NULL ? 0 : rob(root->right->left) + rob(root->right->right));

        int no_steal = rob(root->left) + rob(root->right);
        int res =  max(steal, no_steal);
        map[root] = res;
        return res;
    }
};
// @lc code=end

