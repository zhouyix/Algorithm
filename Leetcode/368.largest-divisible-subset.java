/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        
        int[] dp = new int[nums.length];
        HashMap<Integer,Integer> count = new HashMap<>();
        Arrays.sort(nums);
        int max = 0;
        for(int i=0;i<nums.length;i++)
        {
            dp[i] = -1;
            for(int j=0;j<i;j++){
               if(nums[i]%nums[j] == 0){
                   int newValue = count.getOrDefault(nums[j],0) + 1;
                   if(newValue > count.getOrDefault(nums[i],0)){
                       dp[i] = j;
                       count.put(nums[i],newValue);
                      if(newValue > count.getOrDefault(nums[max],0)){
                          max = i;
                      }
                   }
               }
            }
        }

        int lastIndex = max;
        while(lastIndex!=-1){
            res.add(0,nums[lastIndex]);
            lastIndex = dp[lastIndex];
        }

      
        return res;
    }
}

