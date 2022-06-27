/*
 * @lc app=leetcode.cn id=234 lang=cpp
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        stack<int> st;
        auto cur = head;
        while(cur != NULL) {
            st.push(cur->val);
            cur = cur->next;
        }
        cur =  head;
        while(cur != NULL) {
            if (cur->val != st.top()) {
                return false;
            }
            st.pop();
            cur = cur->next;
        }
        return true;
    }
};
// @lc code=end

