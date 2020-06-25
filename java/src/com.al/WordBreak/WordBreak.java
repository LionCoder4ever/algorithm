package com.al.WordBreak;

import java.util.ArrayList;
import java.util.List;

/**
 * lc #139 word break
 */
public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length()+1;
            boolean[] dp = new boolean[n];
            dp[0] = true;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j,i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n-1];
        }
    }

    public static void main(String[] args) {
        Solution sl = new WordBreak().new Solution();
        List<String> al = new ArrayList<>();
        al.add("leet");
        al.add("code");
        System.out.println(sl.wordBreak("leetcode",al));

        al.clear();
        al.add("apple");
        al.add("pen");
        System.out.println(sl.wordBreak("applepenapple",al));


        al.clear();
        al.add("cats");
        al.add("dog");
        al.add("sand");
        al.add("and");
        al.add("cat");
        System.out.println(sl.wordBreak("catsandog",al));


        al.clear();
        al.add("car");
        al.add("ca");
        al.add("rs");
        System.out.println(sl.wordBreak("cars",al));
    }
}
