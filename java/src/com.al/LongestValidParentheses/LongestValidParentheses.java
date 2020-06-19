package com.al.LongestValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public class Solution{
        public int longestValidParentheses(String s){
            if (s.length() <= 1) return 0;
            Deque<Integer> de = new ArrayDeque<>();
            de.push(-1);
            int ans = 0;
            for(int i = 0; i < s.length();i++){
                int tmp = 0;
                if (s.charAt(i) == '(')	{
                    de.push(i);
                } else {
                    if(!de.isEmpty()){
                        de.pop();
                        if (!de.isEmpty()) {
                            tmp = i - de.peek();
                        } else {
                            de.push(i);
                        }
                    }
                }

                ans = Math.max(ans, tmp);
            }
            return ans;
        }
    }

    public static void main(String[] args){
        Solution s = new LongestValidParentheses().new Solution();
        System.out.println(s.longestValidParentheses("()))"));
        System.out.println(s.longestValidParentheses("()"));
        System.out.println(s.longestValidParentheses("()(()())"));
        System.out.println(s.longestValidParentheses("()))()()"));
    }
}
