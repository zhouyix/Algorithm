/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
   public int maxPoints(Point[] points) {
        int max = 0;
        for (int i = 0; i < points.length && points.length - i > max; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            int samePoint = 1;
            int sameX = 0;
            int tmpMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    samePoint++;
                    continue;
                }
                if (points[j].x == points[i].x) {
                    sameX++;
                } else {
                   double slope = (points[i].y == points[j].y) ? 0 : (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
                    if (map.containsKey(slope)) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 1);
                    }
                    tmpMax = Math.max(tmpMax, map.get(slope));
                }
            }
            int sameXNum = samePoint + sameX;
            tmpMax = tmpMax + samePoint;
            max = Math.max(max, Math.max(sameXNum, tmpMax));
        }
        return max;
    }
}