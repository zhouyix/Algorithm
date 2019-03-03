public class Solution {
    public boolean search(int[] nums, int target) {
         int len=nums.length;
        if(len==0)
        	return false;
        int low=0,high=len-1;
           
           while(low<=high){
           	int mid=(low+high)/2;
           	if(target==nums[mid])
           		return true;
           	else
                if(nums[mid] > nums[low])
                {
                    if(nums[mid] > target && nums[low] <=target)
                    {
                        high=mid-1;
                    }
                    else
                     low=mid+1;
                }
                else if(nums[mid] < nums[low])
                	{
                	    if(nums[mid] < target && nums[high] >= target)
                	    {
                	        low=mid+1;
                	    }
                	    else
                	     high=mid-1;
                	}
                	else
                	low++;
           }
           return false;
    }
}