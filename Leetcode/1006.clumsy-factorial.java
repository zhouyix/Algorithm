/*
 * @lc app=leetcode id=1006 lang=java
 *
 * [1006] Clumsy Factorial
 */
class Solution {
    public int clumsy(int N) {
        int res = cal(N,false);
        return res - helper(N-4);
    }

    public int helper(int N){
        if(N<=0){
            return 0;
        }

         int res = cal(N,true);
         return res + helper(N-4);
    }

    public int cal(int N,boolean flag){
        if(N<=0){
            return 0;
        }
        
        int v1 = N;
        int v2=  N-1;
        int v3= N-2;
        int v4 = N-3;

        int res = v1;
        if(v2 > 0){
            res = v1 * v2;
        }

        if(v3 > 0){
           res = res/v3;
         }

         if(v4 > 0){
             if(flag){
                  res = res-v4;
             }else{
                 res = res + v4;
             }
           
         }

         return res;
    }
}

