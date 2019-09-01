/*
 * @lc app=leetcode id=1031 lang=java
 *
 * [1031] Maximum Sum of Two Non-Overlapping Subarrays
 */
class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        if(A.length==0){
            return 0;
        }

        for(int i=1;i < A.length;i++){
             A[i] = A[i-1] + A[i];
        }

        int res = A[L + M - 1], Lmax = A[L - 1], Rmax = A[M - 1];
        for(int i=L+M;i<A.length;i++){
            //take L first so A[i] - A[i-M] as the M value
            Lmax = Math.max(Lmax,A[i-M]-A[i-M-L]);

            Rmax = Math.max(Rmax,A[i-L]-A[i-L-M]);

           res = Math.max(res,Math.max(Lmax+A[i]-A[i-M],Rmax+A[i]-A[i-L]));
        }
       

        return res;
    }
}

