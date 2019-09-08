/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 */
class Solution {
    public int shortestBridge(int[][] A) {
        int[] i1= new int[2];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] == 1){
                    i1[0]=i;
                    i1[1]=j;
                    break;
                }
            }
        }

        int[][] dir= new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        init(A,i1,dir);
        int h = 0;
        Queue<int[]> q = new LinkedList();

        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }

       
        int c = A.length;
        int r = A[0].length;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                size--;
                int[] p = q.poll();
                for(int i=0;i<dir.length;i++){
                    int x = p[0]+dir[i][0];
                    int y = p[1]+dir[i][1];
    
                    if(x>=0 && x < c && y>=0 && y<r){
                        if(A[x][y]==1){
                           return h;
                        }
                    
                        if(A[x][y] == 0){
                              q.add(new int[]{x,y});
                              A[x][y] = 2;
                        }                  
                }
            }
        }

          h++;
        }

        return h;
    }

    public void init(int[][] A,int[] i1,int[][] dir){
        int c = A.length;
        int r = A[0].length;
        Queue<int[]> q = new LinkedList();
        q.add(i1);

        while(!q.isEmpty()){
            int[] p = q.poll();
            A[p[0]][p[1]] = 2;
            for(int i=0;i<dir.length;i++){
                int x = p[0]+dir[i][0];
                int y = p[1]+dir[i][1];

                if(x>=0 && x < c && y>=0 && y<r && A[x][y]==1){
                    q.add(new int[]{x,y});
                }
            }
        }
    }
}

