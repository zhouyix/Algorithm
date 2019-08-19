/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly=new int[n+1];
        ugly[1]=1;
        int idx2=1;
        int idx3=1;
        int idx5=1;
        for(int i=2;i<=n;i++){
          int min=Math.min(ugly[idx2]*2,Math.min(ugly[idx3]*3,ugly[idx5]*5));
          ugly[i]=min;
          if(min==ugly[idx2]*2){
              idx2++;
          }

          if(min==ugly[idx3]*3){
            idx3++;
        }

        if(min==ugly[idx5]*5){
            idx5++;
        }
        }

        return ugly[n];
    }
}

