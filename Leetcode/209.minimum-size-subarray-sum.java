import java.util.LinkedList;



/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0){
            return 0;
        }

        int i=0,j=0,sum=0,res=Integer.MAX_VALUE;
        while(j<nums.length){
            sum=sum+nums[j++];
            while(sum>=s){
                res=Math.min(res,j-i);
                sum=sum-nums[i++];
            }
        }

        return res==Integer.MAX_VALUE?0:res;
    
    }
}

