/*
 * @lc app=leetcode id=978 lang=java
 *
 * [978] Longest Turbulent Subarray
 */
class Solution {
    public int maxTurbulenceSize1(int[] A) {
        if(A.length==0){
            return 0;
        }
        int[][] dp = new int[A.length][2];
        dp[0][0]=1;
        dp[0][1]=1;
   
        int max = 1;
        for(int i=1;i<A.length;i++){
            if(A[i] > A[i-1]){
                dp[i][1] = Math.max(dp[i-1][0]+1,dp[i][1]);
                dp[i][0]=1;
            }else if(A[i] < A[i-1]){
                dp[i][0] = Math.max(dp[i-1][1]+1,dp[i][0]);
                dp[i][1]=1;
            }else{
                dp[i][0]=1;
                dp[i][1]=1;
            }
            
            max = Math.max(max,Math.max(dp[i][0],dp[i][1]));
        }
        
        return max;
    }

    public int maxTurbulenceSize(int[] A) {
		int n = A.length;
		int base = 0;
		int res = 1;
		for (int i = 1; i < n; i++) {
			int c = Integer.compare(A[i-1], A[i]);
			if (c == 0) {
				base = i;
			}
			else if (i == n - 1 || c * Integer.compare(A[i], A[i+1]) != -1) {
				res = Math.max(res, i - base + 1);
				base = i;
			}
		}
		return res;
	}


}

