/*
 * @lc app=leetcode id=1015 lang=java
 *
 * [1015] Smallest Integer Divisible by K
 */
class Solution {
    public int smallestRepunitDivByK(int K) {
        int res = 1;
        if(K%2==0 || K%5==0){
            return -1;
        }

       int v=0;
       for(int i=0;i<=K;i++){
          v = (v*10+1)%K;
           if(v==0)
             return i+1;
       }

       return -1;
    }
}

