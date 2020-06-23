package com.al.AddBinary;

/**
 * lc #67 add binary
 */
public class AddBinary {
    /**
     * TODO use bit operation
     */
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int ap = a.length() - 1, bp = b.length() - 1;
            char plus = '0';
            char remain = '0';
            while (ap >= 0 && bp >= 0) {
                int sum = plus + a.charAt(ap--) + b.charAt(bp--) - 3 * '0';
                if (sum == 0) {
                    plus = '0';
                    remain =  '0';
                } else if (sum == 1) {
                    plus = '0';
                    remain = '1';
                } else if (sum == 2) {
                    plus = '1';
                    remain = '0';
                } else if (sum == 3) {
                    plus = '1';
                    remain = '1';
                }
                sb.insert(0,remain);
            }
            if (ap != -1) {
                plus = getPlus(a, sb, ap, plus, remain);
            } else if (bp != -1){
                plus = getPlus(b, sb, bp, plus, remain);
            }
            if (plus == '1') {
                return plus + sb.toString();
            }
            return sb.toString();
        }

        private char getPlus(String a, StringBuilder sb, int ap, char plus, char remain) {
            while (ap >= 0) {
                int sum = plus + a.charAt(ap--) - 2 * '0';
                if (sum == 0) {
                    plus = '0';
                    remain =  '0';
                } else if (sum == 1) {
                    plus = '0';
                    remain = '1';
                } else if (sum == 2) {
                    plus = '1';
                    remain = '0';
                }
                sb.insert(0,remain);
            }
            return plus;
        }
    }

    public static void main(String[] args) {
        Solution sl = new AddBinary().new Solution();
        System.out.println(sl.addBinary("11", "1"));
        System.out.println(sl.addBinary("1010", "1011"));
        System.out.println(sl.addBinary("1", "1"));
    }
}
