package com.al.ReverseWordsInAString3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInAString3 {
    class Solution{
        public String reverseWords(String s) {
            return Arrays.stream(s.split(" ")).map((item)-> new StringBuilder(item).reverse()).collect(Collectors.joining(" "));
        }
    }

    public static void main(String[] args) {
       Solution sl = new ReverseWordsInAString3().new Solution();
       String result = sl.reverseWords("Let's take LeetCode contest");
       System.out.println(result);
    }
}
