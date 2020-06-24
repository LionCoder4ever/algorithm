package com.al.TwoSum;

import java.util.HashMap;

/**
 * lc #1 two sum
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums.length < 2) return  new int[]{};
            HashMap<Integer,Integer>  hs = new HashMap<>();
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                hs.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int value = target - nums[i];
                if (hs.containsKey(value) && hs.get(value)!=i) {
                    res[0] = i;
                    res[1] = hs.get(value);
                    return res;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sl = new TwoSum().new Solution();
        int[] test = sl.twoSum(new int[]{2,7,11,15}, 9);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
