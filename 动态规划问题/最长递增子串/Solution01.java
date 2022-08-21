package 动态规划问题.最长递增子串;

import java.util.Arrays;

public class Solution01 {
    public int lengthOfLIS(int[] nums){
        int []dp=new int[nums.length];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]<nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
}
