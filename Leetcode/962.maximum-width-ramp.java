/*
 * @lc app=leetcode id=962 lang=java
 *
 * [962] Maximum Width Ramp
 */
class Solution {
    public int maxWidthRamp(int[] A) {
        Integer[] idx = new Integer[A.length];
        for(int i=0;i<A.length;i++){
            idx[i] = i;
        }

        Arrays.sort(idx,new Comparator<Integer>(){
            @Override
            public int compare(Integer t1, Integer t2) {
                return A[t1] - A[t2] ;
            }
        });

        int minIdx = idx[0],maxV = Integer.MIN_VALUE;
        for(int i=0;i<idx.length;i++){
            maxV = Math.max(maxV,idx[i]-minIdx);
            minIdx = Math.min(idx[i],minIdx);
        }

        return maxV;
    }
}

