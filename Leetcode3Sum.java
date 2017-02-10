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
					while(second < third && nums[second]==nums[second-1])
						second++;
					while(second < third && nums[third]==nums[third+1])
						third--;
				}
				
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