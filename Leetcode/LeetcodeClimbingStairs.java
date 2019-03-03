public class Solution {
    public int climbStairs(int n) {
        if(n<=0)
          return 0;
        if( n <=2 && n >=1)
           return n;
           
        int f1=1,f2=2;
        int i=3,result=0;
        
        while(i<=n)
        {
            result=f1+f2;
            f1=f2;
            f2=result;
            
            i++;
        }
        
        return result;
    }
}