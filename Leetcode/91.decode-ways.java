/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */
class Solution {
    public int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0]=s.charAt(0)=='0' ? 0 : 1;
        for(int i=1;i<s.length();i++){
            dp[i] = s.charAt(i)=='0' ? 0 : dp[i-1];
            if((s.charAt(i-1)=='1' && s.charAt(i) <= '9') || (s.charAt(i-1)=='2' && s.charAt(i) <= '6')){
                dp[i]+= i-2 >=0 ? dp[i-2] : 1;
            }
        }

        return dp[s.length()-1];
    }
}

