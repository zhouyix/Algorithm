import java.util.Arrays;

/*
 * @lc app=leetcode id=593 lang=java
 *
 * [593] Valid Square
 */
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Long, Integer> map = new HashMap<>();
		
		long val = cal(p1, p2);
		map.put(val, map.getOrDefault(val, 0)+1);
		val = cal(p1, p3);
		map.put(val, map.getOrDefault(val, 0)+1);
		val = cal(p1, p4);
		map.put(val, map.getOrDefault(val, 0)+1);
		val = cal(p2, p3);
		map.put(val, map.getOrDefault(val, 0)+1);
		val = cal(p2, p4);
		map.put(val, map.getOrDefault(val, 0)+1);
		val = cal(p3, p4);
		map.put(val, map.getOrDefault(val, 0)+1);
		
		if(map.values().contains(2) && map.values().contains(4))
		    return true;
        return false;
}

public long cal(int[] s, int[] p){
    return ((long)(s[0]-p[0])*(s[0]-p[0]) + (long)(s[1]-p[1])*(s[1]-p[1]));
}
}

