package com.al;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class NonOverLappingIntervals {
	@Test
	void test() {
	    Solution s = new Solution();
	    int ans = s.eraseOverlapIntervals(new int[][]{new int[]{1,2}, new int[]{2,3}, new int[]{3,4}, new int[]{1,3}});
		System.out.println(ans);
	}

	class Solution {
		public int eraseOverlapIntervals(int[][] intervals) {
			Arrays.sort(intervals, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});

			int n = intervals.length;
			int[] f = new int[n];
			Arrays.fill(f, 1);
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if(intervals[j][1] <= intervals[i][0]) {
						f[i] = Math.max(f[i],f[j]+1);
					}
				}
			}
			return n - Arrays.stream(f).max().getAsInt();
		}

		public int greedyEraseOverlapIntervals(int[][] intervals) {
			Arrays.sort(intervals, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});

			int n = intervals.length;
			int right = intervals[0][1];
			int ans = 0;
			for (int i = 1; i < n; i++) {
				if(intervals[i][0] >= right) {
					ans++;
					right = intervals[i][1];
				}
			}
			return n - ans;
		}
	}
}
