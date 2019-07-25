/*
 * @lc app=leetcode id=481 lang=java
 *
 * [481] Magical String
 */
class Solution {
    public int magicalString(int n) {
        if(n==0)
        return 0;
        char[] sbn = new char[n];
        int res = 1;
        int sum = 0;
        int cIndex = 0;
        sbn[0] = '1';
        int fillLen = 1;
        while(fillLen < n){
            if(fillLen > sum){
                sum = sum + sbn[cIndex] - '0';
                cIndex++;
            } else if(fillLen < sum){
                sbn[fillLen]=sbn[fillLen-1];
                fillLen++;
                if(sbn[fillLen-1] == '1'){
                    res++;
                }
            }
            else{
                // check c to decide the next char
                sbn[fillLen] = sbn[fillLen-1] == '1' ? '2' : '1';
                fillLen++;
                if(sbn[fillLen-1] == '1'){
                    res++;
                }
            }
        }

        return res;
    }
}

