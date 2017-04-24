public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         int m=obstacleGrid.length;
         if(m==0)
           return 0;
         int n=obstacleGrid[0].length;
          if(n==0)
           return 0;
           
         int[][] map=new int[m][n];
         if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
           return 0;
           map[0][0]=1-obstacleGrid[0][0];
         for(int i=1;i<m;i++)
               map[i][0]= (map[i-1][0] > 0 && obstacleGrid[i][0]==0) ? 1 : 0;
         for(int j=1;j<n;j++)
                map[0][j]=(map[0][j-1] > 0 && obstacleGrid[0][j]==0) ? 1 : 0;
              
        for(int i=1;i<m;i++)
          for(int j=1;j<n;j++)
          {
         if(obstacleGrid[i][j]==0)
              map[i][j] = map[i-1][j]+map[i][j-1];
         
        else
             map[i][j] = 0;
          }
          
          return map[m-1][n-1];
    }
}