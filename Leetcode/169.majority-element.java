/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (51.33%)
 * Total Accepted:    357.5K
 * Total Submissions: 690.4K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        int record = nums[0];
        int sum = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == record){
                sum ++;
            }else{
                sum--;
                if(sum == 0){
                    sum = 1;
                    record = nums[i];
                }
            }
        }

        return record;
        
    }
}

