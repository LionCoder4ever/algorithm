package com.al.KthLargestElementInAnArray;

import java.util.PriorityQueue;

/**
 * lc #215
 */
public class KthLargestElementInAnArray {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // use heap get top k
            PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
            for (int i = 0; i < nums.length; i++) {
                if (minHeap.size() < k){
                    minHeap.add(nums[i]);
                } else {
                    if (nums[i] <= minHeap.peek()) {
                        continue;
                    } else {
                        minHeap.poll();
                        minHeap.add(nums[i]);
                    }
                }
            }
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        Solution sl = new KthLargestElementInAnArray().new Solution();
        System.out.println(sl.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(sl.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
