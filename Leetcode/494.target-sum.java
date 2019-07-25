/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
       int[] res = new int[1];
        dfs(0,0,nums,S,res);
        return res[0];
    }

    public void dfs(int i,int v,int[] nums,int s,int[] res){
        if(i==nums.length){
            if(v == s){
                res[0]++;
                return;
            }

            return;
        }

        dfs(i+1,v+nums[i],nums,s,res);
        dfs(i+1,v-nums[i],nums,s,res);
    }
}

