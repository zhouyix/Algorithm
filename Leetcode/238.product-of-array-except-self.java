/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int[] end=new int[nums.length];
        // int[] start =new int[nums.length];

        // for(int i=0;i<nums.length;i++){
        //     end[i] = (i-1>=0?end[i-1]:1)*nums[i];
        // }

        // for(int i=nums.length-1;i>=0;i--){
        //    start[i] = (i+1<nums.length?start[i+1] : 1)*nums[i];
        // }

        // int[] res=new int[nums.length];
        // for(int i=0;i<nums.length;i++){
        //     res[i] = (i-1>=0?end[i-1]:1) *( i+1<nums.length?start[i+1]:1);
        // }

        int[] res=new int[nums.length];
        int tmp=1;
        for(int i=0;i<nums.length;i++){
            res[i] =tmp;
            tmp =tmp* nums[i];
        }

        tmp=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i] =res[i]*tmp;
            tmp =  tmp*nums[i];
        }
        return res;
    }
}

