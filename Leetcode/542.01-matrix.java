/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m= matrix.length;
        if(m==0 || matrix[0].length==0)
        {
            return new int[m][0];
        }
    
        int n=matrix[0].length;
        int[][] res = new int[m][n];
      
      
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(matrix[i][j]==1){
                 int[] p = bfs(matrix,i,j);
                 res[i][j] = Math.abs(p[0]-i)+Math.abs(p[1]-j);
               }else{
                   res[i][j]=0;
               }
           }
        }
        return  res;
    }
    
    public int[] bfs(int[][] matrix,int i,int j){ 
         Queue<int[]> q = new LinkedList();
        int m= matrix.length;
        int n=matrix[0].length;

        q.add(new int[]{i,j});

        while(!q.isEmpty()){
            int[] pair = q.poll();
            if(matrix[pair[0]][pair[1]]==0){
                return pair;
            }

            if(pair[0]>0){
                q.add(new int[]{pair[0]-1,pair[1]});
            }

            if(pair[1]>0){
                q.add(new int[]{pair[0],pair[1]-1});
            }

            if(pair[0]<m-1){
                q.add(new int[]{pair[0]+1,pair[1]});
            }

            if(pair[1]<n-1){
                q.add(new int[]{pair[0],pair[1]+1});
            }
        }
 
         return new int[]{i,j};
       
        }

}

