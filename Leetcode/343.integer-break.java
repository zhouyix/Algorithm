/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            dp[i] = dp[i-1];
            for(int j=1;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),dp[j] * (i-j)));
            }
        }

        return dp[n];
    }
	
	 public int integerBreak2(int n){
        if(n<=3){
            return n-1;
        }

        int res = 1;
        while(n>4){
            n = n - 3;
            res = res * 3;
        }

        return res * n;
    }
}

