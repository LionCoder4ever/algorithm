/*
 * @lc app=leetcode.cn id=236 lang=cpp
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    // 记录所有节点的父节点
    unordered_map<int, TreeNode*> fp;

    // 访问记录
    unordered_map<int, bool> visited;

    void dfs(TreeNode* root) {
        if (root->left != NULL) {
            fp[root->left->val] = root;
            dfs(root->left);
        }
        if (root->right != NULL) {
            fp[root->right->val] = root;
            dfs(root->right);
        }
    }

    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        // root节点没有父节点了
        fp[root->val] = NULL;
        dfs(root);

        // 先找p的父节点
        while(p != NULL) {
            visited[p->val] = true;
            p = fp[p->val];
        }

        while(q != NULL) {
            if (visited[q->val]) {
                return q;
            }  
            q = fp[q->val];
        }
        return NULL;
    }
};
// @lc code=end

