import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (31.19%)
 * Total Accepted:    94.7K
 * Total Submissions: 301K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: [3]
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * 
 */
class Solution {
    public int majorityElement1(int[] nums) {
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

    public List<Integer> majorityElement(int[] nums) {
         List<Integer> res = new ArrayList();
        if(nums.length <=2 )
        {
           for(int i =0;i<nums.length;i++)
           if(i==0 || nums[i-1]!=nums[i])
             res.add(nums[i]);
           return res;
        }

        
        int record = nums[0];
        int record2 = nums[0];

        int sum = 1;
        int sum2 = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == record){
                sum ++;
            } 
            else if(nums[i] == record2){
                sum2 ++;
            } else if(sum == 0){
               
                    sum = 1;
                    record = nums[i];
                
            } else if(sum2== 0){
                    sum2 = 1;
                    record2 = nums[i];
            }else{
                sum--;
                sum2--;
            }
        }

       sum=0;
       sum2=0;
       for(int i=0;i<nums.length;i++){
           if(nums[i] == record)
           sum++;

           if(nums[i] == record2)
           sum2++;
       }

       if(sum > nums.length/3)
       res.add(record);

       //attention
       if(record!=record2 && sum2 > nums.length/3)
       res.add(record2);

        return res;
    }
}

