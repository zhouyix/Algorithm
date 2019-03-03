public class Solution {
    public int[][] generateMatrix(int n) {
        int rs=0;
        int cs=0;
        int re=n-1;
        int ce=n-1;
        int[][] arr=new int[n][n];
        if(n==0)
        return arr;
        
        int i=0,j=0,num=1;
        while(rs <= re && cs <=ce)
        {
            for( j=cs;j<=ce;j++)
                    arr[i][j]=num++;
            j=j-1;
            i=i+1;
            
               
            for(i=rs+1;i<=re;i++)
               arr[i][j]=num++;
               
            i=i-1;
            j=j-1;
          
         
             for(;j>=cs;j--)
              arr[i][j]=num++;
              
              j=j+1;
              i=i-1;
             
              
              for(;i>=rs+1;i--)
                arr[i][j]=num++;
                
            i++;
            j++;
            
            rs++;
            cs++;
            re--;
            ce--;
            
        }
        return arr;
    }