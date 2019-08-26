/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0||text2.length()==0){
            return 0;
        }

        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
               dp[i][j] =  Math.max(i-1>=0 ? dp[i-1][j]:0 , j-1>=0 ? dp[i][j-1]:0);
               if(text1.charAt(i)==text2.charAt(j)){
                   dp[i][j] = Math.max(i-1>=0 && j-1>=0 ? dp[i-1][j-1]+1:1,dp[i][j]);
               }
            }
        }

        return dp[text1.length()-1][text2.length()-1];
    }
}

