/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (28.93%)
 * Total Accepted:    176.7K
 * Total Submissions: 596.3K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount < 0)
            return -1;

        int[] dp = new int[amount + 1];
        for(int a = 1;a<=amount;a++){
            dp[a] = Integer.MAX_VALUE;
            if(a-coins[0] >=0 && dp[a-coins[0]] != Integer.MAX_VALUE)
              dp[a] = dp[a-coins[0]]+1;
        }

        for (int i = 1; i < coins.length; i++)
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0 && dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

            }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
