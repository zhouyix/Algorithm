/*
 * @lc app=leetcode id=1139 lang=java
 *
 * [1139] Largest 1-Bordered Square
 */
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] left = new int[rows][cols];
        int[][]   up = new int[rows][cols];

        for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++){
            if(grid[i][j]==1){
                left[i][j] = j==0 ? 1 : left[i][j-1]+1;
                up[i][j] = i==0 ? 1 : up[i-1][j]+1;
            }
        }

        for(int len= Math.min(rows,cols);len>=1;len--){
            for(int i=0;i+len-1<rows;i++)
            for(int j=0;j+len-1<cols;j++){
                if(left[i][j+len-1]>=len && left[i+len-1][j+len-1]>=len
                && up[i+len-1][j] >= len && up[i+len-1][j+len-1]>=len){
                    return len*len;
                }
            }
        }

        return 0;
    }
}

