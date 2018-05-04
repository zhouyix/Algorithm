 public int minPatches(int[] nums, int n) {
       int count = 0;
	   int index = 0;
	   long miss = 1;
	 
	   
	   while(miss <= n)
	   {
		   if(index < nums.length && miss >= nums[index])
		   {
			   miss = miss + nums[index++];
		   }
		   else
		   {
               miss = miss + miss;
               count++;
		   } 
	   }
		
	
		return count;
	}