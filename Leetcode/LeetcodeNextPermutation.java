public class Solution {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        if(len<=1)
        	return;
        int first=len-2,last=first+1;
        while(first>= 0  && nums[first]>=nums[first+1])
        	 first--;
        	 if(first==-1) first=0;
        		last=first+1;
        		boolean flag=false;
        		while( last < len && nums[last]>nums[first])
        			{
        			    last++;
        			    flag=true;
        			}
        		if(flag){
        		  last=last-1;
        	int temp=nums[first];
        	nums[first]=nums[last];
        	nums[last]=temp;
                  }
                  else
                  first=-1;

        	//first+1到len-1全部倒序排序
        	for(int i=first+1;i<(first+len+1)/2;i++){
            int temp=nums[i];
        	nums[i]=nums[first+len-i];
        	nums[first+len-i]=temp;
        	}

    }
}