/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Sequence
 */
class Solution {
    public int longestArithSeqLength(int[] A) {
        HashMap<Integer,Integer>[] dp = new HashMap[A.length];

        dp[0] = new HashMap();
        int max=0;
        for(int i=1;i<A.length;i++){
            dp[i] = new HashMap();
            for(int j=0;j<i;j++){
               int gap = A[i]-A[j];
               dp[i].put(gap,dp[j].getOrDefault(gap,0)+1);
               max = Math.max(max,dp[i].get(gap));
            }
        }

        return max==0 ? 0 :max+1;
    }
}

