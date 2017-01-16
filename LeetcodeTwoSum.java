public class Solution {
    public int[] twoSum(int[] nums, int target) {
     int[] results=new int[2];
		   HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		      for(int i=0;i<nums.length;i++){
		          if(hm.containsKey(target-nums[i])){
		        	  int index1=i+1;
		        	  int index2=hm.get(target-nums[i])+1;
		        	  if(index1>index2){
		        		  results[0]=index2;
		        		  results[1]=index1;
		        	  }
		        	  else
		        	  {
		        		  results[0]=index1;
		        		  results[1]=index2;
		        	  }
		          }
		       hm.put(nums[i],i);   
		      }
		          return results;
    }
}lgorithm