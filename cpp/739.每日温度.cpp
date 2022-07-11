/*
 * @lc app=leetcode.cn id=739 lang=cpp
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        
        stack<int> st;
        vector<int> ans(n);

        for(int i=n-1;i>=0;i--) {
            while(!st.empty() && temperatures[st.top()] <= temperatures[i]) {
                st.pop();
            }
            if (!st.empty()) ans[i] = st.top() - i;
            st.push(i);
        }
        return ans;
    }
};
// @lc code=end

