/*
 * @lc app=leetcode id=1020 lang=java
 *
 * [1020] Number of Enclaves
 */
class Solution {
    public int numEnclaves(int[][] A) {
        int[][] dirt = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                res += A[i][j];
                if (i == 0 || i == A.length - 1 || j == 0 || j == A[0].length - 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] < 0 || cur[0] >= A.length || cur[1] < 0 || cur[1] >= A[0].length || A[cur[0]][cur[1]] == 0) continue;
            res--;
            A[cur[0]][cur[1]] = 0;
            for (int[] d : dirt) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                queue.offer(new int[]{x, y});
            }
        }
        return res;  
    }
}

