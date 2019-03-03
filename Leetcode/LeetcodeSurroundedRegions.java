public class Solution {
    public class Point{
        int x;
        int y;
        
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
         if(board.length == 0 || board[0].length ==0)
	           return ;
	           
	        Queue<Point> queue = new LinkedList<Point>();
	        
	        for(int i =0;i<board.length;i++)
	        	for(int j =0;j<board[0].length;j++)
	        	{
	        		if(i==0 || i==board.length-1||j==0||j==board[0].length-1){
	        			if(board[i][j] == 'O'){
	        				board[i][j] = 'y';
	        				queue.offer(new Point(i,j));
	        			}
	        				
	        		}
	        	}
	        
	        while(!queue.isEmpty()){
	        	 Point p = queue.poll();
	        	 int x = p.x;
	        	 int y = p.y;
	        	 //up
	        //	 if(board[x][y]=='y')
	        	  //  continue;
	        //	 board[x][y] = 'y';
	        	 if(x-1>=0 && board[x-1][y] == 'O')
	        	 {
	        		 board[x-1][y] = 'y';
     				queue.offer(new Point(x-1,y));
	        	 }
	        	 
	        	 //down
	        	 if(x+1<board.length && board[x+1][y] == 'O')
	        	 {
	        		 board[x+1][y] = 'y';
     				queue.offer(new Point(x+1,y));
	        	 }
	        	 
	        	 //right
	        	 if(y+1<board[0].length && board[x][y+1] == 'O')
	        	 {
	        		 board[x][y+1] = 'y';
     				queue.offer(new Point(x,y+1));
	        	 }
	        	 
	        	 //left
	        	 if(y-1>=0 && board[x][y-1] == 'O')
	        	 {
	        		 board[x][y-1] = 'y';
     				queue.offer(new Point(x,y-1));
	        	 } 
	        }
	        
	        for(int i =0;i<board.length;i++)
	        	for(int j =0;j<board[0].length;j++)
	        	{
	        		
	        			if(board[i][j] == 'y'){
	        				board[i][j] = 'O';
	        			}
	        				
	        			else
	        				if(board[i][j]=='O'){
	        					board[i][j]='X';
	        				}
	        					
	        	}
    }
}