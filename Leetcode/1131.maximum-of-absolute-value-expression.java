/*
 * @lc app=leetcode id=1131 lang=java
 *
 * [1131] Maximum of Absolute Value Expression
 */
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res=0;
		int tem=0;
		for(int i=0;i<arr1.length-1;i++){
			for(int j=i+1;j<arr1.length;j++){
				tem=Math.abs(arr1[i]-arr1[j])+Math.abs(arr2[i]-arr2[j])+Math.abs(i-j);
				res=Math.max(tem,res);                
			}
		}
		return res;        
    }
}

