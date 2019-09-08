/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
       int[] dp = new int[days[days.length-1]+1];
       dp[days[0]] = Math.min(costs[0],Math.min(costs[1],costs[2]));
       for(int i=1;i<days.length;i++){
           int j = days[i-1]+1;
           for(; j<days[i];j++){
               dp[j] = dp[days[i-1]];
           }

           dp[j] = Math.min(dp[j-1]+costs[0],Math.min(j-7>=0 ? dp[j-7]+costs[1] : costs[1],j-30>=0 ? dp[j-30]+costs[2]:costs[2]));
       }

       return dp[dp.length-1];
    }
}

