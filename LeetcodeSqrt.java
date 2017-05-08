public class Solution {
    public int mySqrt(int x) {
       if(x==0 || x==1)
          return x;
          int res =0;
        int left = 1,right = x;
        while(left <= right){
            int mid = (left+right)/2;
            if(mid == x/ mid)
              return mid;
            else
              if(mid > x/mid)
                right = mid-1;
              else
              {
                left = mid+1;
                res = mid;
                
              }
        }
              
        return res;
        }
}