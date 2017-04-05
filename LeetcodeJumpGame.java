public class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null)
          return false;
        
          
        int most = nums[0];
        for(int i= 1;i<nums.length;i++)
        {
            if(most >= i)
            {
                most = Math.max(nums[i]+i,most);
            }
        }
        
        return most >= nums.length-1;
    }
}