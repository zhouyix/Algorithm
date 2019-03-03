public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)
          return 0;
          
        if(triangle.size()==1)
          return triangle.get(0).get(0);
          
        int len = triangle.size();
        int[][] sum = new int[len][triangle.get(len-1).size()];
        
        for(int i = 0;i<len;i++)
          sum[i][0] = triangle.get(i).get(0);
          
        int i=1,j=0,tmp=0; 
       for( i=1;i<len;i++)
          for(j=0;j<triangle.get(i).size();j++)
             sum[i][j] = triangle.get(i).get(j) +(( (j-1>=0 && sum[i-1][j-1] < sum[i-1][j]) || j >= triangle.get(i-1).size()) ? sum[i-1][j-1] : sum[i-1][j]);
    
      tmp = sum[i-1][0]; 
      for(j =0 ;j<triangle.get(len-1).size();j++)
      {
          if(tmp > sum[i-1][j])
             tmp = sum[i-1][j];
      }
      return tmp;
    }
}