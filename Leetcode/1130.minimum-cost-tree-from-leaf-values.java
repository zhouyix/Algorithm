/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 */
class Solution {
    public int mctFromLeafValues1(int[] arr) {
        int res=0;
        List<Integer> list = new ArrayList<Integer>();
        for(int val : arr)
            list.add(val);
        
        while(list.size() != 1){
            int best_mul = Integer.MAX_VALUE;
            int best_ind = -1;
            for(int i=0;i<list.size()-1;i++){
                int a = list.get(i);
                int b = list.get(i+1);
                if(a*b < best_mul){
                    best_mul = a*b;
                    best_ind = i;
                }
            }
            
            int max = Math.max(list.get(best_ind),list.get(best_ind+1));
            res += best_mul;
            list.remove(best_ind);
            list.set(best_ind, max);
        }
        
        return res;
    }  
    
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        int[][] max = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i ++) {
            int value = 0;
            for(int j = i; j < arr.length; j ++) {
                if(arr[j] > value) {
                    value = arr[j];
                }
                max[i][j] = value;
            }
        }
        for(int len = 1; len < arr.length; len ++) {
            for(int left = 0; left + len < arr.length; left ++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;
                if(len == 1) {
                    dp[left][right] = arr[left]*arr[right];
                } else {
                    for(int k = left; k < right; k ++) {
                        dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k+1][right] + max[left][k]*max[k+1][right]);
                    }
                }
            }
        }
        return dp[0][arr.length-1];
    }
}

