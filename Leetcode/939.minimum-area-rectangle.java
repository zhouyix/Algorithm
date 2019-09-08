/*
 * @lc app=leetcode id=939 lang=java
 *
 * [939] Minimum Area Rectangle
 */
class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, HashSet<Integer>> xMap = new HashMap<>();
       
        for(int[] point : points) {
            xMap.computeIfAbsent(point[0], f -> new HashSet<>()).add(point[1]);
        }
        
        int minRec = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                if(points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
                
                if(xMap.get(points[i][0]).contains(points[j][1]) 
                  && xMap.get(points[j][0]).contains(points[i][1])) { 

                    minRec = Math.min(minRec, Math.abs(points[j][0] - points[i][0]) * Math.abs(points[i][1] - points[j][1]));  
                }
                
                
            }
        }
        
        return minRec == Integer.MAX_VALUE ? 0 : minRec;                                                                                                                                                                                              
    }
}

                                                                                                      