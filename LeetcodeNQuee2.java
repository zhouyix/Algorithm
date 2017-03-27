public class Solution {
    int res=0;
    public int totalNQueens(int n) {
	        if(n==0)
	          return 0;
	        int[] board=new int[n];
	        
	        for(int i=0;i<n;i++)
	           board[i]=-1;
	        helper(board,n,0);
	        return res;
	    }
	    
	    public void helper(int[] board,int n,int i)
	    {
	       
	        if(i==n)
	        {
	            res++;
	            return;
	        }
	        
	       for(int k=0;k<n;k++)
	          {
	              
	             if(isValid(board,n,i,k))
	            	 {
	            	 board[i]=k;
	                 helper(board,n,i+1);
	                 board[i]=-1;
	            	 }
	          }

	    }
	    
	    public boolean isValid(int[] board,int n,int row,int col)
	    {
	    	for(int i = 0; i < row; i++) {
	              if(board[i]==col || Math.abs(row-i)==Math.abs(col-board[i]))
	            	  return false;
	        }
	    	
	            return true;
	    }
}