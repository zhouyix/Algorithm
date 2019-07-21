/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */
class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 0){
            return amount == 0 ? 1 : 0;
        }

    
        int[][] dp = new int[amount+1][coins.length];
        for(int i=0;i<=amount;i++){
            if(i% coins[0] ==0){
                dp[i][0] = 1;
            }
        }
 
        for(int i=0;i<coins.length;i++){
            dp[0][i] = 1;
        }
 
        for(int i=1;i<=amount;i++){
            for(int j = 1;j<coins.length;j++){
                dp[i][j] += dp[i][j-1];
                if(i - coins[j] >= 0){
                    dp[i][j] += dp[i-coins[j]][j];
                }
            }
        }
 
        return dp[amount][coins.length-1];
     
    }
}

