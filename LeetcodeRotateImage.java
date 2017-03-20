public class Solution {
    public void rotate(int[][] matrix) {
        //up to side
        int len=matrix.length;
        for(int i=0;i<len/2;i++)
        {
            for(int j=0;j<len;j++)
            {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[len-1-i][j];
                matrix[len-1-i][j]=tmp;
            }
        }
        //symmetry rotate
        for(int i=0;i<len;i++)
          for(int j=i+1;j<len;j++)
          {
              int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
          }
    }
}