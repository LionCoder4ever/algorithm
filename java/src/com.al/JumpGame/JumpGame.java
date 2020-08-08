package com.al.JumpGame;

public class JumpGame {
    class Solution{
        public boolean canJump(int[] nums) {
            int reach = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i>reach) {
                    return false;
                }
                reach = Math.max(reach,i+nums[i]);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sl = new JumpGame().new Solution();
        boolean a1 = sl.canJump(new int[]{2,3,1,1,4});
        boolean a2 = sl.canJump(new int[]{3,2,1,0,4});
        System.out.println(a1);
        System.out.println(a2);
    }
}
