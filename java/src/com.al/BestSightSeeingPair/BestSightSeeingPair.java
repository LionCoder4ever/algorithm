package com.al.BestSightSeeingPair;

public class BestSightSeeingPair {
    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            // find the max (A[i] + i) base on A[j], which A[j] - j is calculated
            // max represent A[i] + i
            int ans = 0, max = A[0] + 0;
            for (int j = 1; j < A.length; j++) {
                // calc the ans, update the max(A[i] + i)
                ans = Math.max(ans, max+A[j]-j);
                max = Math.max(A[j]+j, max);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sl = new BestSightSeeingPair().new Solution();
        int max = sl.maxScoreSightseeingPair(new int[]{8,1,5,2,6});
        System.out.println(max);
        max = sl.maxScoreSightseeingPair(new int[]{1,2});
        System.out.println(max);
    }
}
