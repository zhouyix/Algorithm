/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */
class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
      
        // for(int i=1;i<=n;i++){
        //     dp[i] =dp[i-1]+1;
        //    if(i/(int)Math.sqrt(i) == Math.sqrt(i)){
        //        dp[i] = 1;
        //    }else{
        //        for(int j=1;j<=i/2;j++){
        //            dp[i] = Math.min(dp[i],dp[j]+dp[i-j]);
        //        }
        //    }
        // }

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<=n;i++){
            for(int j =1;i+j*j<=n;j++){
                dp[i+j*j] =Math.min(dp[i+j*j],dp[i]+1);
            }
        }


        return dp[n];
    }
}

