/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 */
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int sum = 0,max=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum = sum+ (nums[i]==0 ? -1 : 1);
        
                if(map.containsKey(sum)){
                    max = Math.max(max,i-map.get(sum));
                }else{
                    map.put(sum,i);
                }
        }

        return max;
        
    }
}

