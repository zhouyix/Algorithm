public class Solution {
    public int minDistance(String word1, String word2) {
        int rows=word1.length()+1;
        int cols=word2.length()+1;
        
        int[][] d=new int[rows][cols];
        
        for(int i=0;i<rows;i++)
          d[i][0]=i;
          
        for(int j=0;j<cols;j++)
          d[0][j]=j;
          
        for(int i=1;i<rows;i++)
          {
              char c=word1.charAt(i-1);
              for(int j=1;j<cols;j++)
              {
                  char m=word2.charAt(j-1);
                  if(c==m)
                    d[i][j]=d[i-1][j-1];
                  else
                  {
                      d[i][j]=Math.min(d[i-1][j],Math.min(d[i][j-1],d[i-1][j-1]))+1;
                  }
              }
          }
        return d[rows-1][cols-1];
          
    }
}