/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 */
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int[] mod = new int[K];
        for(int i=0;i<A.length;i++){
            sum = sum + A[i];
            mod[(sum%K+K)%K]++;
        }
        
        int res=mod[0];
        for(int i=0;i<mod.length;i++){
            if(mod[i] > 0){
                res = res + (mod[i]*(mod[i]-1))/2;
            }
        }
        
        return res;
    }
}

