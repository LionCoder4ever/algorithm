package com.al.PartitionEqualSubsetSum;

public class PartitionEqualSubsetSum {
    class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            if (sum % 2 != 0) return false;
            sum = sum >> 1;
            // two state
            boolean[][] dp = new boolean[n + 1][sum + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = true;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum; j++) {
                    // negative index
                    if (j - nums[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // selections
                        // dont put sums[i] in the count
                        // if put sums[i], the pre count must be  "j-nums[i-1]"
                        dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[n][sum];
        }
    }

    public static void main(String[] args) {
        Solution sl = new PartitionEqualSubsetSum().new Solution();
        System.out.println(sl.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(sl.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(sl.canPartition(new int[]{1, 5, 11, 5, 6, 6}));
        System.out.println(sl.canPartition(new int[]{1, 2, 5}));
    }
}
