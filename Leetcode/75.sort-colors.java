/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */
class Solution {
    public void sortColors(int[] nums) {
        int p0=0;
        int p2=nums.length-1;

        int i=0;
        while(i<=p2){
            if(nums[i]==0){
                nums[i]=nums[p0];
                nums[p0]=0;
                p0++;
            }

            if(nums[i]==2){
                nums[i]=nums[p2];
                nums[p2]=2;
                p2--;
                i--;
            }

            i++;
        }

       
    }
}

