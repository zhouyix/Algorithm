/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0] == o2[0] ? o1[1] -o2[1] : o1[0] - o2[0];
            }
        });

        int lastIndex = 0;
        int res = 0;
        for(int i=1;i<intervals.length;i++){
             if(intervals[i][0] < intervals[lastIndex][1]){
                 res++;

                 // try to remove the interval which covers more scope
                 if(intervals[i][1] <= intervals[lastIndex][1]){
                     lastIndex = i;
                 }
             }else{
                 lastIndex=i;
             }
        }

        return res;
    }
}

