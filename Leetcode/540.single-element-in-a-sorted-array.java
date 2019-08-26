/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
           res = res ^ nums[i];
        }

        return res;
    }
}

