/*
 * @lc app=leetcode.cn id=543 lang=cpp
 *
 * [543] 二叉树的直径
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
public:
    int ans;
    int diameterOfBinaryTree(TreeNode* root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode* root){
        if (root == NULL) return 0;
        int l = dfs(root->left);
        int r = dfs(root->right);
        ans = max(l +r , ans);
        return max(l,r) + 1;
    }
};
// @lc code=end

