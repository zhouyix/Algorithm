/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */
class NumMatrix {

    int[][] sum;
    public NumMatrix(int[][] matrix) {
    if(matrix.length!=0 && matrix[0].length != 0){
          sum = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++){
                sum[i][j] = matrix[i][j] + 
                (i-1 >= 0 ? sum[i-1][j] : 0) +
                (j-1 >= 0 ? sum[i][j-1] : 0) -
                (i-1 >=0 && j-1 >=0 ? sum[i-1][j-1] : 0);
            }
    }
   
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sum.length==0 || sum[0].length == 0){
            return 0;
        }

        return sum[row2][col2] -
        (col1 - 1 >= 0 ? sum[row2][col1-1] : 0) -
        (row1-1>=0 ? sum[row1-1][col2] : 0)  +
        (row1-1 >=0 && col1 - 1>=0 ? sum[row1-1][col1-1]:0) ;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

