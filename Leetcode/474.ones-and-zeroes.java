/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
    
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        int count = 0;
        for(int i=1;i<=strs.length;i++){
            int cm = 0,cn=0;
            for(int t=0;t<strs[i-1].length();t++){
                if(strs[i-1].charAt(t) == '0'){
                    cm++;
                }else{
                    cn++;
                }
            }

            for(int j=0;j<=m;j++){
            for(int k=0;k<=n;k++){
                dp[i][j][k] = dp[i-1][j][k];
                 if(j-cm >=0 && k-cn >=0){
                   dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j-cm][k-cn]+1);
                   }
               }   
            }
            
            count  = Math.max(count,dp[i][m][n]);
        } 

        return count;
    }
}

