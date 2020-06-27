package com.al.FirstMissingPositive;

import java.util.HashSet;

/**
 * lc #41
 */
public class FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums.length == 1) return nums[0] - 1 >= 1 ? 1: ((nums[0] + 1) < 1 ? 1 : nums[0] + 1);
            int min =  0;
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
               if (nums[i] > 0) {
                   hs.add(nums[i]);
                   if (min > nums[i]) min = nums[i];
               }
            }
            int ans = 1;
            for (int i = 1; i < nums.length+1; i++) {
                if (hs.contains(i)) {
                    ans++;
                } else {
                    ans = i;
                    return ans < 1 ? 1 : ans;
                }
            }
            return ans < 1 ? 1 : ans;
        }
    }

    public static void main(String[] args) {
        Solution sl = new FirstMissingPositive().new Solution();
        System.out.println(sl.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(sl.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(sl.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(sl.firstMissingPositive(new int[]{7}));
        System.out.println(sl.firstMissingPositive(new int[]{1}));
        System.out.println(sl.firstMissingPositive(new int[]{2}));
        System.out.println(sl.firstMissingPositive(new int[]{-5}));
        System.out.println(sl.firstMissingPositive(new int[]{2,1}));
    }
}
