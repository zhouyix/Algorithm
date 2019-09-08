/*
 * @lc app=leetcode id=945 lang=java
 *
 * [945] Minimum Increment to Make Array Unique
 */
class Solution {
    public int minIncrementForUnique(int[] A){
        Arrays.sort(A);
        int pre = -1,sum=0;
        for(int v: A){
            if(v <= pre){
                int diff = pre-v+1;
                sum += diff;
                pre = v + diff;
            }else{
                pre = v;
            }
        }

        return sum;
    }
    public int minIncrementForUnique1(int[] A) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap();
        int max = 0;
        for(int v : A){
            map.put(v,map.getOrDefault(v,0)+1);
            max = Math.max(v,max);
        }

        int i=0;
        Arrays.sort(A);
        while(i<=max){
           if(map.getOrDefault(i,0) <= 1){
               i++;
           }else{
               int count = map.get(i);
               sum = sum + count-1;
               map.put(i+1,map.getOrDefault(i+1,0)+count-1);
               if(i+1 > max){
                   max = max+1;
               }

               i++;
           }
        }

        return sum;
    }
}

