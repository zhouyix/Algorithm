public class Solution {
    public boolean exist(char[][] board, String word) {
        int len=word.length();
        if(len==0)
          return true;
        if(board==null || board.length==0 || board[0].length==0)  
        return false;  
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++)
          for(int j=0;j<col;j++)
          {
              if(search(board,word,0,i,j))
                 return true;
          }
        
          return false;
    }
    
    public boolean search(char[][] board,String word,int index,int i,int j)
    {
        if(index==word.length())
          {
              return true;
          }
       if(i >= board.length || j>=board[0].length || i < 0 || j < 0 || board[i][j]!=word.charAt(index))
         return false;
         
         char tmp=board[i][j];
         board[i][j]='$';
          boolean res = search(board,word,index+1,i-1,j)   
                || search(board,word,index+1,i+1,j)  
                || search(board,word,index+1,i,j-1)   
                || search(board,word,index+1,i,j+1);  
    board[i][j] = tmp;  
    return res;  
    }
}