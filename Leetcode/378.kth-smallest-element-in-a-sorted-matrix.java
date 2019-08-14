/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return matrix[t1[0]][t1[1]] - matrix[t2[0]][t2[1]];
            }
        });
        
        int count = 0;
        p.add(new int[]{0,0});
        int[] v = p.peek();
        visited[0][0] = true;
        while(count < k){
            v = p.poll();

            count++;
            if(v[1]+1 < matrix[0].length && !visited[v[0]][v[1]+1]) {
                p.add(new int[]{v[0], v[1] + 1});
                visited[v[0]][v[1]+1] = true;
            }

            if(v[0]+1 < matrix.length && !visited[v[0]+1][v[1]]){
                p.add(new int[]{v[0]+1,v[1]});
                visited[v[0]+1][v[1]] = true;
            }
        }

        return matrix[v[0]][v[1]];
    }
}

