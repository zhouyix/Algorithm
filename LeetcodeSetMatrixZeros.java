public class Solution {
    public void setZeroes(int[][] matrix) {
      int i=0,j=0;
        int row=matrix.length;
        if(row==0)
          return ;
        int col=matrix[0].length;
        if(col==0)
          return ;
        int[] visited=new int[col];
        int[] visitedT=new int[row];

        for(i=0;i<row;i++)
        {
            
        
          for(j=0;j<col;j++)
          {
              if(visited[j]==0 && matrix[i][j]==0 )
              {
                  visitedT[i]=1;
                  for(int m=0;m<row;m++)
                     {
                         if(m > i && matrix[m][j]==0)
                            visitedT[m]=1;
                            
                         matrix[m][j]=0;
                         
                     }
                  visited[j]=1;
              }
           }
            int k=0;
            while(k<row)
            {
              if(k <= i && visitedT[k]==1)
                 for(int n=0;n<col;n++)
                       matrix[k][n]=0; 
                k++;
            }
         
        }
    }
}