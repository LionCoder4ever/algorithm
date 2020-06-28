package com.al.MinimumSizeSubarraySum;

/**
 * lc #209
 */
public class MinimumSizeSubarraySum {
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            // init window
            int left = 0,right = 0;
            int ans = Integer.MAX_VALUE;
            int sum = 0;
            boolean maxflag = true;
            while (right<nums.length){
                sum += nums[right++];
                while (sum >= s){
                    maxflag = false;
                   ans = Math.min(ans, right-left);
                   sum -= nums[left++];
                }
            }
            return maxflag ? 0 : ans;
        }
    }
    public static void main(String[] args) {
        Solution sl = new MinimumSizeSubarraySum().new Solution();
        System.out.println(sl.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(sl.minSubArrayLen(100, new int[]{}));
        System.out.println(sl.minSubArrayLen(15, new int[]{1,2,3,4,5}));

        System.out.println(sl.minSubArrayLen(3, new int[]{1,1}));
    }
}
