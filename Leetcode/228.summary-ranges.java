/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int len=nums.length;
        List<String> res= new ArrayList();
        for(int i=0;i<len;i++){
            int num=nums[i];
            while(i<len-1&&nums[i]+1==nums[i+1]){
                i++;
            }

            if(num!=nums[i]){
                res.add(num+"->"+nums[i]);
            }else{
                res.add(num+"");
            }
        }

        return res;
    }
}

