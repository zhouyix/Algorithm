/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */
class Solution {
    public int hIndex(int[] citations) {
        // for(int i=0;i<citations.length;i++){
        //     if(citations[i] >=citations.length-i){
        //         return citations.length-i;
        //     }
        // }

        int len =citations.length;
    int l=0,r=citations.length-1;
    while(l<=r){
        int m=(l+r)/2;
        if(citations[m]==  len-m){
            return  len-m;
        }else if(citations[m] <len-m){
            l= m+1;
        }else{
            r=m-1;
        }
    }
                return   len-l;
}
    
}

