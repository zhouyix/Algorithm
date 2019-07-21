import java.util.HashMap;

/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 */
class Solution {
    public class Record{
        public int len;
        public int time;
        public Record(int len,int time){
            this.len = len;
            this.time = time;
        }
    }
    public int findNumberOfLIS(int[] nums) {
        Record[] dp = new Record[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i] = new Record(1,1);
        }

        Record max = new Record(Integer.MIN_VALUE,0);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && dp[i].len <= dp[j].len +1){
                    if(dp[i].len==dp[j].len+1){
                        dp[i].time = dp[i].time + dp[j].time;
                    }else{
                        dp[i].len = dp[j].len + 1;
                        dp[i].time = dp[j].time ;
                    }
                    
                    if(max.len == dp[i].len){
                        max.time = max.time + dp[j].time;
                    }else if(max.len < dp[i].len){
                       max.len = dp[i].len;
                        max.time = dp[i].time;
                    }
                }
            }
        }

        return max.len == Integer.MIN_VALUE ? nums.length : max.time;
    }
}

