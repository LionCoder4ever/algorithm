package com.al.MaximumLengthOfRepeatSubarray;

/**
 * lc #718
 */
public class MaximumLengthOfRepeatSubarray {
    class Solution {
        public int findLength(int[] A, int[] B) {
            int[][] dp = new int[A.length+1][B.length+1];
            int ans = 0;
            for (int i = 1; i < A.length+1; i++) {
                for (int j = 1; j < B.length+1; j++) {
                    dp[i][j] = A[i-1] == B[j-1] ? dp[i-1][j-1] + 1 : 0;
                    ans = Math.max(dp[i][j], ans);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sl = new MaximumLengthOfRepeatSubarray().new Solution();
        int[] a = {1,2,3,2,1};
        int[] b = {3,2,1,4,7};
        System.out.println(sl.findLength(a,b));
        a = new int[]{0,0,0,0,1};
        b = new int[]{1,0,0,0,0};
        System.out.println(sl.findLength(a,b));
    }
}
