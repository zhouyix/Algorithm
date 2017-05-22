public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length <= 1)
          return ;
        int index0=-1,index2=nums.length;
        int i = 0;
        while(i<index2)
        {
            if(nums[i]==1)
              {
                  i++;
              }
              else
              if(nums[i]==0)
              {
                  swap(nums,index0+1,i);
                  index0++;
                  i++;
              }
              else
              {
                  swap(nums,index2-1,i);
                  index2--;
              }
        }
    }
    
    public void swap(int[] nums,int i,int j)
    {
       
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}