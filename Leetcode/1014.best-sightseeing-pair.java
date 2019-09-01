/*
 * @lc app=leetcode id=1014 lang=java
 *
 * [1014] Best Sightseeing Pair
 */
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int maxI = A[0];
        int res = 0;
        for(int j=1;j<A.length;j++){
           res = Math.max(res,maxI+A[j]-j);
           maxI = Math.max(maxI,A[j]+j);
        }

        return res;
    }
}

