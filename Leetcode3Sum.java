/*
 *   First use three loops
     Problem1.miss some cases 
     Reason:in order to avoid duplication ,the while loop1,llop2 were placed tag1,so if x = i+ j/2 + j/2 case miss
     
   
      Problem2.time out
      Reason:three loops time complexicity is too high so consider the array is sorted so binary search.
   
 */


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
	List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return lists;
		Arrays.sort(nums);
		int len = nums.length;
		int first= 0;
		for (; first < len; first++) {
			int second=first+1;
			int third=len-1;
			while(second<third){
				int sum=nums[first]+nums[second]+nums[third];
				if(sum==0){
					lists.add(Arrays.asList(nums[first], nums[second], nums[third]));
					second++;
					third--;
					while(second < third && nums[second]==nums[second-1]) //loop1
						second++;
					while(second < third && nums[third]==nums[third+1])    //loop2
						third--;
				}
				
				//tag1 place the loop* in the first edition 
				else 
					if(sum>0)
				{
					third--;
					while(second < third && nums[third]==nums[third+1])
						third--;
				}
				else
				{
					second++;
					while(second < third && nums[second]==nums[second-1])
						second++;
				}
			}
          while(first+1<len && nums[first+1]==nums[first])
        	  first++;
          
		}
		
		return lists;
    }
}
