/*
 * @lc app=leetcode id=539 lang=java
 *
 * [539] Minimum Time Difference
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
    
        for(int i=0;i<timePoints.size();i++){
            char[] t1=timePoints.get(i).toCharArray();
            char[] t2=timePoints.get((i+1)%timePoints.size()).toCharArray();

            int h1 = (t1[0] - '0') * 10 + t1[1] - '0';
            int m1 = (t1[3] - '0') * 10 + t1[4] - '0';
            int h2 = (t2[0] - '0') * 10 + t2[1] - '0';
            int m2 = (t2[3] - '0') * 10 + t2[4] - '0';
            int diff = (h2 - h1) * 60 + (m2 - m1);
            if (i == timePoints.size() - 1) diff += 24 * 60;
            res = Math.min(res, diff);
            
        }
        
        return res;

    }
}

