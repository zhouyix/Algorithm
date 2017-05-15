public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int row=matrix.length;
		if(row==0)
			return false;
		int col=matrix[0].length;
		if(col==0)
			return false;
		int crow=0,ccol=col-1;
		if(target < matrix[0][0] || target > matrix[row-1][col-1])
			return false;
	  while(crow < row && ccol >=0)
	  {
	      if(target == matrix[crow][ccol])
	        return true;
	       if(target < matrix[crow][ccol])
	          {
	              ccol--;
	          }
	        else
	          crow++;
	  }
	  return false;
	
    }
}