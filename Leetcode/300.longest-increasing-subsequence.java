/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = 0;
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                   
                }
            }
             max = Math.max(dp[i],max);
        }

        return max;
    }
	
	 public int lengthOfLIS2(int[] nums) {
        if(nums.length == 0)
            return 0;
        List<Integer> pool = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int pos = binarysearch(pool, nums[i]);
            if(pos >= pool.size())
                pool.add(nums[i]);
            else
                pool.set(pos, nums[i]);
        }

        return pool.size();
    }

    public int binarysearch(List<Integer> nums, int target){
        int left = 0, right = nums.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums.get(mid) == target)
                return mid;
            else if(nums.get(mid) < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}

