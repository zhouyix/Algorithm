/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */
class Solution {
    public int hIndex(int[] citations) {
        // if(citations.length==0){
        // return 0;
        // }

        // Arrays.sort(citations);
        // for(int i=0;i<citations.length;i++){
        // if(citations[i]>0 && citations.length-i <= citations[i]){
        // return citations.length-i;
        // }
        // }

        int[] bucket = new int[citations.length + 1];
        for (int c : citations) {
            if (c >= citations.length) {
                bucket[citations.length]++;
            } else {
                bucket[c]++;
            }
        }

        int count = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }
}
