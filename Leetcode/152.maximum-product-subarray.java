/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (28.45%)
 * Total Accepted:    197.7K
 * Total Submissions: 686.8K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
        int global = nums[0];
        int positive = nums[0];
        int negative = nums[0];
    
        for(int i= 1;i<nums.length;i++){
            int tmp = positive;
           positive = Math.max(nums[i],Math.max(positive*nums[i],negative*nums[i]));
           negative = Math.min(nums[i],Math.min(tmp*nums[i],negative*nums[i]));

           global = Math.max(global,positive);
        }

        return global;
        
    }

    public int maxProduct1(int[] nums) {
        int[] dpP = new int[nums.length];
        int[] dpN = new int[nums.length];

        int global = nums[0];
        dpP[0] = nums[0];
        dpN[0] = nums[0];
        for(int i= 1;i<nums.length;i++){
           dpP[i] = Math.max(nums[i],Math.max(dpP[i-1]*nums[i],dpN[i-1]*nums[i]));
           dpN[i] = Math.min(nums[i],Math.min(dpP[i-1]*nums[i],dpN[i-1]*nums[i]));

           global = Math.max(global,dpP[i]);
        }

        return global;
        
    }
}

