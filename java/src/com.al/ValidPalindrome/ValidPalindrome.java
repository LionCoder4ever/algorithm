package com.al.ValidPalindrome;

public class ValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            if (s.isEmpty()) return true;
            s = s.toLowerCase();
            int pos = 0, endpos = s.length() - 1;
            char posC, endposC;
            while (pos <= endpos) {
                posC = s.charAt(pos);
                endposC = s.charAt(endpos);
                if (!((posC >= '0' && posC <= '9') || (posC >= 'a' && posC <= 'z'))) {
                    pos++;
                    continue;
                }
                if (!((endposC >= '0' && endposC <= '9') || (endposC >= 'a' && endposC <= 'z'))) {
                    endpos--;
                    continue;
                }
                if (posC != endposC) {
                    return false;
                }
                pos++;
                endpos--;
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Solution sl = new ValidPalindrome().new Solution();
        System.out.println(sl.isPalindrome("car ac"));
    }
}
