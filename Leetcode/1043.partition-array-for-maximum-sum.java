/*
 * @lc app=leetcode id=1043 lang=java
 *
 * [1043] Partition Array for Maximum Sum
 */
class Solution {
    // public int maxSumAfterPartitioning(int[] A, int K) {
    //     int[] max =new int[1];
    //     helper(A,K,0,0,max);
    //     return max[0];
    // }

    // public void helper(int[] A,int K,int idx,int sum,int[] max){
    //     if(idx == A.length){
    //         max[0] = Math.max(max[0],sum);
    //         return;
    //     }

    //     for(int i=idx;i<A.length;i++){
    //         int v = A[i];
    //         for(int k=0;k<K && i+k < A.length;k++)
    //         {
    //            v = Math.max(v,A[i+k]);
    //            helper(A,K,i+k+1,sum+v*(k+1),max);
    //         }
    //     }
    // }

    public int maxSumAfterPartitioning(int[] A, int K) {
           int[] dp = new int[A.length];
           dp[0]=A[0];
         
           for(int i=1;i<A.length;i++){
               int v = A[i];
               for(int j= 0;i-j >= 0 && j < K ;j++){
                  v = Math.max(v,A[i-j]);
                  dp[i] = Math.max(dp[i],(i-j-1 >=0 ? dp[i-j-1] : 0) + v * (j+1));
               }
           }
             return dp[A.length-1];
         }


}

