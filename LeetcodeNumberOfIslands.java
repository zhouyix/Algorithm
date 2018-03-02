public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid[0].length==0)
          return 0;
          
          int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
          for(int j=0;j<grid[0].length;j++){
              if(!visited[i][j] && grid[i][j]=='1')
              {
                  dfs(grid,i,j,visited);
                  count++;
              }
          }
          
          return count;
    }
    
    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        } else if (visited[i][j] || grid[i][j]=='0' ) {
            return;
        }

        visited[i][j] = true;
        dfs(grid, i - 1, j, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
    }
}