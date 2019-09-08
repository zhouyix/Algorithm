/*
 * @lc app=leetcode id=926 lang=java
 *
 * [926] Flip String to Monotone Increasing
 */
class Solution {
    public int minFlipsMonoIncr(String S) {
        // dp[0] ends with 0 substr flip count
        // dp[1] ends with 1 sub flip count 
        int[] dp = new int[2];
        dp[0]=S.charAt(0)=='0' ? 0:1;
        dp[1]=S.charAt(1)=='1' ? 0:1;

        for(int i=1;i<S.length();i++){
            if(S.charAt(i)=='0'){
                dp[1] = dp[1] + 1;
            }else{
                // if 1 then substr-1 can end with 0 or 1
                dp[1] = Math.min(dp[0],dp[1]);

                // if 1 then must flip when need to end with 0
                dp[0] = dp[0]+1;
            }

        }

        return Math.min(dp[0],dp[1]);

       
    }
}

