public class Solution {
  
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0)
          return 0;
          if(m==1 || n==1)
            return 1;
       m--;
       n--;
       int j=1;
       long result=1;
       for(int i=m+1;i<=m+n;j++,i++)
       {
           result=result * i;
           result=result/j;
       }
       return (int)result;
    }
   
}