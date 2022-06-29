/*
 * @lc app=leetcode.cn id=297 lang=cpp
 *
 * [297] 二叉树的序列化与反序列化
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
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string str;
        serialize_help(root, str);
        return str;
    }

    void serialize_help(TreeNode* root, string& str) {
        if (root == NULL) {
            str += "NONE,";
            return;
        } else {
            str += to_string(root->val) + ",";
            serialize_help(root->left, str);
            serialize_help(root->right,str);
        }
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        string str;
        list<string> array;
        for (auto ch: data) {
            if (',' == ch) {
                array.push_back(str);
                str.clear();
            } else {
                str.push_back(ch);
            }
        }
        if (!str.empty()) {
            array.push_back(str);
        }
        return deserialize_help(array); 
    }

    TreeNode* deserialize_help(list<string>& array) {
        if ("NONE" == array.front()) {
            array.erase(array.begin());
            return NULL;
        }
        TreeNode* root = new TreeNode(stoi(array.front()));
        array.erase(array.begin());
        root->left = deserialize_help(array);
        root->right = deserialize_help(array);
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));
// @lc code=end

