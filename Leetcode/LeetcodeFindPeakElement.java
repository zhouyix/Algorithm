public class Solution {
    public int findPeakElement(int[] nums) {
         if(nums.length==0)
          return 0;
         int i =1;
        while(i<nums.length && nums[i]>=nums[i-1]){
            i++;
        }
        
       
          return i-1;
    }
}