/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        int i=0,j=n-1;
        while(i>=0 && i<m&&j>=0&&j<n){
            if(matrix[i][j] < target){
                i++;
            }else  if(matrix[i][j] > target){
                j--;
            }else{
                return true;
            }
        }

        return false;
    }
}

