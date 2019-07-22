/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 */
class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0)
        return word2.length();

        if(word2.length()==0)
        return word1.length();

        int[][] dp = new int[word1.length()][word2.length()];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 1 : 0;
        for(int i=1;i<word1.length();i++){
           dp[i][0] = word2.charAt(0) == word1.charAt(i) ?
            1:
            dp[i-1][0];    
            
        }

        for(int i=1;i<word2.length();i++){
            dp[0][i] =  word1.charAt(0) == word2.charAt(i) ?
               1:
               dp[0][i-1];
            }

        for(int i=1;i<word1.length();i++)
        for(int j=1;j<word2.length();j++){
            dp[i][j] = Math.max(dp[i][j-1],
             dp[i-1][j]);
            if(word1.charAt(i) == word2.charAt(j)){
                dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i][j]);
            }
        }

        return word1.length() + word2.length() - 2*dp[word1.length()-1][word2.length()-1];
    }
}

