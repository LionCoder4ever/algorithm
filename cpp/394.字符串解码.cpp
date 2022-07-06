/*
 * @lc app=leetcode.cn id=394 lang=cpp
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
public:
    string getDigit(string& s, size_t& ptr) {
        string result = "";
        while (isdigit(s[ptr])) {
            result.push_back(s[ptr++]);
        }
        return result;
    }
    
    string getString(vector<string> &str) {
        string result;
        for (auto &s: str) {
            result += s;
        }
        return result;
    }

    string getStringSt(stack<string> &str) {
        string result;
        while(!str.empty()) {
            result.insert(0, str.top());
            str.pop();
        }
        return result;
    }

    string decodeString(string s) {
        stack<string> st;
        int n = s.size();
        size_t ptr = 0;
        while(ptr < n) {
            auto c = s[ptr];
            if (isdigit(c)) {
                string digit = getDigit(s, ptr);
                st.push(digit);
            } else if(isalpha(c) || c == '[') {
                st.push(string(1,c));
                ptr++;
            } else {
                ptr++;
                // ]
                // 记录[]中的string
                vector<string> v;
                while(st.top() != "[") {
                    v.push_back(st.top());
                    st.pop();
                }
                reverse(v.begin(), v.end());
                // 弹出 [
                st.pop();
                // 栈顶的数字
                auto numstr = st.top();
                st.pop();
                auto num = stoi(numstr);
                auto needLoop = getString(v); 
                string afterLoop = "";
                while(num-- > 0) {
                    afterLoop += needLoop;
                }
                st.push(afterLoop);
            }
        }
        return getStringSt(st);
    }
};
// @lc code=end

