public class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        int pos=0;
        for(int i=0;i<len;i++){
        	if(i==0 || nums[i]!=nums[i-1]){
        		nums[pos++]=nums[i];
        	}
        }
        return pos;
    }
}