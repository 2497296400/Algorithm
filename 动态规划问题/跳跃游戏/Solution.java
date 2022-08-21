package 动态规划问题.跳跃游戏;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] ints = {1,1,1,0};
        System.out.println(canJump(ints));
    }
    public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= dp[i-1]) {
                dp[i] = Math.max(dp[i-1], i + nums[i]);
                if (dp[i] >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean canJump2(int []ints){
        int footMax=0;
        for(int i=0;i<ints.length;i++){
            if(i<=footMax){
                footMax=Math.max(footMax,i+ints[i]);
                if(footMax>=ints.length-1){
                    return true;
                }

            }
        }
        return false;
    }
}