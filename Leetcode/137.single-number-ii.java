/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */
class Solution {
    public int singleNumber(int[] nums) {
        int  res=0;
        for(int b=0;b<32;b++){
            int count=0;
             for(int  i=0;i<nums.length;i++){
                if(((nums[i]>>b)&1)==1){
                    count++;
                  
                }
             }

              
             if(count%3!=0){
                   res=res|(1<<b);
             }
           

        }

        return res;
       
    }
}

