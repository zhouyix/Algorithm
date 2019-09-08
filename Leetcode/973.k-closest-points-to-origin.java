/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0]*t1[0] + t1[1]*t1[1] - t2[0]*t2[0] - t2[1]*t2[1];
            }
        });

        for(int i=0;i<points.length;i++){
            q.add(points[i]);
        }
        
        int[][] res = new int[K][2];
        for(int i=0;i<K;i++){
           if(!q.isEmpty()) res[i] = q.poll();
        }

        q.toArray(new int[0][0]);

        return  res;
    }
}

