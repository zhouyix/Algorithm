public class Solution {
    public int singleNumber(int[] nums) {
       int[] cal = new int[32];
       
    
          for(int j =0;j<nums.length;j++)
           for(int i=0;i<32;i++)
          {
               if((nums[j] & (1<<i)) != (nums[j] & 0<<i) )
                   cal[i]++;
          }
          
          int result = 0;
          for(int i=0;i<cal.length;i++){
              if(cal[i]%3!=0)
                 result = result + ( 1 << i);
          }
          
          return result;
    }
}