/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int [nums.length][2];
        int max = 0;
        for(int i=0;i<nums.length;i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
            for(int j = 0;j<i;j++){
                if(nums[i]-nums[j] > 0){
                    dp[i][0] = Math.max(dp[j][1]+1,dp[i][0]);
                }else if(nums[i]-nums[j] < 0){
                    dp[i][1] = Math.max(dp[j][0]+1,dp[i][1]);
                }
            }

            max = Math.max(max,Math.max(dp[i][0],dp[i][1]));
        }

         return  max;
    }
	
	
   
}

