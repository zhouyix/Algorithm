/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 */
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        HashMap<Integer,Integer> map = new HashMap(); 
        map.put(0,1);
        int s = 0,sum=0,res=0;
        for(int i=0;i<A.length;i++){
            sum = sum+A[i];
            if(map.containsKey(sum-S)){
                res = res + map.get(sum-S);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }
       
        return res;
    }
}

