/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        if(grid.length==0 || grid[0].length==0){
            return 0;
        }

        int n = grid[0].length;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0] == 1 ? Integer.MAX_VALUE:0;
        for(int i=1;i<m;i++)
        {
           dp[i][0] = grid[i][0] == 1 ? Integer.MAX_VALUE : (dp[i-1][0] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i-1][0]+1);
        }

        for(int i=1;i<n;i++)
        {
           dp[0][i] = grid[0][i] == 1 ? Integer.MAX_VALUE : (dp[0][i-1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[0][i-1]+1);
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j] == 0){
                    int upper = i-1 >=0 && grid[i-1][j] ==0 ? dp[i-1][j] : Integer.MAX_VALUE;
                    int left = j-1 >=0 && grid[i][j-1] ==0 ? dp[i][j-1] : Integer.MAX_VALUE;
                    int cor = i-1>=0 && j-1>=0 && grid[i-1][j-1] == 0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
                    
                    int min = Math.min(upper,left);
                    dp[i][j] = Math.min(min!=Integer.MAX_VALUE ? min +1 : Integer.MAX_VALUE,
                    cor!=Integer.MAX_VALUE ? cor + 2 : Integer.MAX_VALUE
                    );
                }else{
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        return dp[m-1][n-1] == Integer.MAX_VALUE ? -1 : dp[m-1][n-1];
    }
}

