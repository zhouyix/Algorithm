public class Solution {
  public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int first=0;
      int len=nums.length;
      int min=Math.abs(nums[0]+nums[1]+nums[len-1]-target);
      int result=nums[0]+nums[1]+nums[len-1];
      for(;first<len-1;first++)
      {
      	int second=first+1;
      	int third=len-1;
      	while(second < third){
      		int sum=nums[first]+nums[second]+nums[third];
      		int diff=Math.abs(sum-target);
      		if(diff<min)
      		{
      			result=sum;
      			min=diff;
      		}

      		if(sum-target==0){
                return  sum;
      		}
      		else
      			if(sum-target < 0){
      				second++;
      				while(second < third && nums[second]==nums[second-1])
      					second++;
      			}
      			else
      			{
      				third--;
      				while(second < third && nums[third]==nums[third+1])
      					third--;
      			}
      	}

       while(first+1 < len && nums[first+1]==nums[first])
       	first++;
      } 
      return result;
    }
}