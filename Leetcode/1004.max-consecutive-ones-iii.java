/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */
class Solution {
    public int longestOnes(int[] A, int K) {
        // int count1 = 0;
        // int start = 0,end=0;
        // int res = 0;
        // while(end < A.length){
        //     if(A[end] == 1){
        //         count1++;
        //     }

        //     if(end + 1- start - count1 <= K){
        //         res = Math.max(res,end-start+1);
        //         end++;
        //     }else{
        //         while(start <=end && end-start+1-count1 > K){
        //             if(A[start]==1){
        //                 count1--;
        //             }
        //             start++;
        //         }
        //     }
        // }

        // return res;

        int count0 = 0;
        int start = 0,end=0;
        int res = 0;
        while(end < A.length){
            if(A[end] == 0){
                count0++;
            }

            end++;

            while(start < end && count0 > K){
                if(A[start] ==0){
                    count0--;
                }

                start++;
            }

            res = Math.max(res,end-start);
        }
        return res;

    }
}

