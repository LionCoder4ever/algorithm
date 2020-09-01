package com.al.PredictWinner;

public class PredictWinner {
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            return getScore(nums, 0, nums.length-1) >= 0;
        }
        int getScore(int[] arr, int l, int r) {
            if (l == r) return arr[l];
            return Math.max(arr[l]-getScore(arr,l+1,r), arr[r] - getScore(arr,l,r-1));
        }
    }
}
