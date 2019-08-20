/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */
class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        while(low<high){
            int m=(low+high)/2;
            if(nums[m]>nums[high]){
                low=m+1;
            }else {
                high=m;
            }
        }

        return nums[low];
    }
}

