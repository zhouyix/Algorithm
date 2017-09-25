public class Solution {
    public int longestConsecutive(int[] nums) {
         if(nums.length==0)
	          return 0;
	        int max = 0;
	        HashSet<Integer> set = new HashSet<Integer>();
	        for(int i=0;i<nums.length;i++)
	            set.add(nums[i]);
	        
	        for(int i=0;i<nums.length;i++){
	        	int tmp = nums[i]-1;
	        	int len = 1;
	        	
	        	while(set.contains(tmp)){
	        		set.remove(tmp);
	        		len++;
	        		tmp--;
	        		
	        	}
	        	
	        	tmp=nums[i]+1;
	        	while(set.contains(tmp)){
	        		set.remove(tmp);
	        		len++;
	        		tmp++;
	        	}
	        	
	        	if(len > max)
	        		max = len;
	        }
	        
	        return max;
        
    }
}