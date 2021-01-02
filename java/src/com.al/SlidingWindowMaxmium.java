package com.al;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMaxmium {
    @Test
    void test() {
        Solution s = new Solution();
        int[] ans = s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
        System.out.println();
        ans = s.maxSlidingWindow(new int[]{1},1);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
        System.out.println();
        ans = s.maxSlidingWindow(new int[]{1,-1},1);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
        System.out.println();
        ans = s.maxSlidingWindow(new int[]{9,11},2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
        System.out.println();
        ans = s.maxSlidingWindow(new int[]{4,-2},2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // set compare function
            PriorityQueue<Map> p = new PriorityQueue(k, new Comparator<Map<Integer, Integer>>() {
                @Override
                public int compare(Map o1, Map o2) {
                    return (Integer) o2.keySet().iterator().next() - (Integer) o1.keySet().iterator().next();
                }
            });

            // the first window
            for (int i = 0; i < k; i++) {
                HashMap map = new HashMap();
                map.put(nums[i],i);
                p.offer(map);
            }

            int n = nums.length;
            int[] ans = new int[n-k+1];
            // get the first maximum
            ans[0] = (int) p.peek().keySet().iterator().next();
            // [1,3,-1,-3,5,3,6,7], 3
            //    [3,-1,-3]
            //       [-1.-3,5]
            for (int i = k; i < n; i++) {
                HashMap map = new HashMap();
                map.put(nums[i],i);
                // insert into the priority queue
                p.offer(map);
                // the maximum value may not in the current window
                // if not exist, poll the value
                while ((Integer)(p.peek().values().iterator().next()) <= (i-k)) {
                    p.poll();
                }
                ans[i-k+1] = (int) p.peek().keySet().iterator().next();
            }
            return ans;
        }
    }
}
