import java.util.HashSet;

/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */
class Solution {
    public int minFallingPathSum(int[][] A) {
       int[][] dp = new int[A.length][A[0].length];

       for(int i=0;i<A.length;i++)
       for(int j=0;j<A[0].length;j++){
           if(i==0)
             dp[i][j] = A[i][j];
             else{
                 dp[i][j] = Math.min(j-1 >= 0 ? dp[i-1][j-1] : Integer.MAX_VALUE, 
                 Math.min(j+1 < A[0].length ? dp[i-1][j+1] : Integer.MAX_VALUE,dp[i-1][j]))+A[i][j];
             }
       }

       int min = Integer.MAX_VALUE;
       for(int i=0;i<A[0].length;i++){
           min = Math.min(dp[A.length-1][i],min);
       }

       return min;
    }
}
