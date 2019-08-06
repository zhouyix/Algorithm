/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 */
class Solution {
    public int integerReplacement(int n) {
       return recursive(n,0);
    }

    public int recursive(int n,int step){
        if(n==1){
            return step;
        }

        if(n == Integer.MAX_VALUE){
            return 32;
        }

        if(n%2==0){
            return recursive(n>>1, step+1);
        }else{
            int one = recursive(n+1, step+1);
            int two = recursive(n-1, step+1);
            return Math.min(one,two);
        }
    }
}

