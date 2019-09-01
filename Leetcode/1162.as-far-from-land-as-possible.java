/*
 * @lc app=leetcode id=1162 lang=java
 *
 * [1162] As Far from Land as Possible
 */
class Solution {
    public int maxDistance(int[][] grid) {
        int m=grid.length;
        if(m==0||grid[0].length==0){
            return -1;
        }

      
        int n=grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++){
            if(grid[i][j]==1){
               q.offer(new int[]{i,j,0});
            }
        }

        int[] cur, dx={0,0,1,-1},dy={1,-1,0,0};
        int res = -1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                --size;
                cur = q.poll();
                int x = cur[0];
                int y=cur[1];
                res = cur[2];
                for(int i=0;i<4;i++){
                    int nx = x+dx[i];
                    int ny=  y+dy[i];
                    if(nx >=0 && nx <m && ny>=0 && ny <n && grid[nx][ny] == 0){
                        grid[nx][ny] = res+1;
                        q.offer(new int[]{nx,ny,grid[nx][ny]});
                    }
                }
            }
        }

        return res == 0 ? -1 : res;
       
      
    }
}

