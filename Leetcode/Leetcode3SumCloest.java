/*
  Use gap (always positive) to record closet degree.
  use flag to know the positive or negative.
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
		int gap = Integer.MAX_VALUE;
		boolean flag = true;
		for (int i = 0; i+2 < nums.length; i++) {
			 int low = i+1;
			 int high = nums.length -1;
			 while(low  < high)
			 {
				 int sum = nums[i]+nums[low]+nums[high];
				 
				 if(sum == target)
				 {
						return target;
                     
				 }
				 
				 
				 if(sum > target)
				 {
					 if(gap > Math.abs(sum-target))
					 {
						 flag = true;
						 gap = Math.abs(sum-target);
					 }
					 
					 high--;
				 }
				 else  if(sum < target )
				 {
					 if(gap > Math.abs(sum-target))
					 {
						 flag = false;
						 gap = Math.abs(sum-target);
					 }
					 
					 low++;
				 }
			     }
            
            while(i+2 < nums.length && nums[i+1]==nums[i])
            {
                i++;
            }
		}

		return flag ? target + gap : target-gap;
    }
}
