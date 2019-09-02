/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
       int i=0,j=0;
        ArrayList<int[]> list = new ArrayList();
        while(i<A.length && j < B.length){
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if(start <= end)
                list.add(new int[] {start, end});

            if(A[i][1] < B[j][1])
                i++;
            else if (A[i][1] > B[j][1])
                j++;
            else { i++;j++; }

        }

      
            int[][] res = new int[list.size()][2];
            for( i=0;i<list.size();i++){
                res[i][0] = list.get(i)[0];
                res[i][1] = list.get(i)[1];
            }

            return res;
    }
}

