/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */
class Solution {
    public class Interval{
        public int s;
        public int e;
        public Interval(int s,int e){
            this.s = s;
            this.e = e;
        }
    }

    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
        return 0;
        Interval[] p = new Interval[points.length];
        for(int i=0;i<points.length;i++){
            p[i] = new Interval(points[i][0],points[i][1]);
        }

        Arrays.sort(p,new Comparator<Interval>(){
            @Override
            public int compare(Interval o1,Interval o2){
                return o1.s == o2.s ? o1.e - o2.e : o1.s - o2.s;
            }
        });

        Interval dummy = new Interval(0,Integer.MAX_VALUE);
        int i=0;
        int res = 0;
        while(i<p.length){
           if(p[i].s > dummy.e){
               res++;
               dummy = p[i];
           }else{
               dummy.s = Math.max(dummy.s,p[i].s);
               dummy.e = Math.min(dummy.e,p[i].e);
           }

           i++;
        }

        return res+1;
    }
}

