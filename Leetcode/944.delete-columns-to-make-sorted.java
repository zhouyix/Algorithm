/*
 * @lc app=leetcode id=944 lang=java
 *
 * [944] Delete Columns to Make Sorted
 */
class Solution {
    public int minDeletionSize(String[] A) {
        int idx = 0;
        int count=0;
        if(A.length <= 1){
            return 0;
        }

        while(idx < A[0].length()){
             for(int j=1;j<A.length;j++){
                if(A[j-1].charAt(idx) > A[j].charAt(idx)){
                    count++;
                    break;
                }
            }

                idx++;
        } 
        
        return count;
    }

   
}

