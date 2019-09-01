/*
 * @lc app=leetcode id=1035 lang=java
 *
 * [1035] Uncrossed Lines
 */
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        // how to convert to Longest common sequence
                int[][] dp = new int[A.length][B.length];
                for(int i=0;i<A.length;i++){
                    for(int j=0;j<B.length;j++){
                        if(A[i] == B[j]){
                            dp[i][j] = Math.max((i-1>=0 && j-1>=0 ? dp[i-1][j-1]:0)+1,dp[i][j]);
                        }

                        dp[i][j] = Math.max(dp[i][j],Math.max(i-1>=0 ? dp[i-1][j]:0 ,j-1>=0 ? dp[i][j-1] : 0));
                    }
                }

                return dp[A.length-1][B.length-1];
    }
    // public int maxUncrossedLines(int[] A, int[] B) {
    //     if(A.length > B.length){
    //         int[] tmp = A;
    //         A = B;
    //         B = tmp;
    //     }

    //     HashMap<Integer,LinkedList<Integer>> map = new HashMap();
    //     for(int i=0;i<B.length;i++){
    //         if(!map.containsKey(B[i])){
    //            map.put(B[i],new LinkedList());
    //         }

    //         map.get(B[i]).add(i);
    //     }

    //     int[] res = new int[1];
    //     helper(A,map,0,res,0,-1,B.length-1);
    //     return res[0];
    // }

    // public void helper(int[] A, HashMap<Integer,LinkedList<Integer>> map,int idx, int[] res,int v,int bound,int maxBound){
    //     if(bound == maxBound || A.length == idx){
    //         res[0] = Math.max(res[0],v);
    //         return;
    //     }

    //     if(map.containsKey(A[idx]) && map.get(A[idx]).size() >0){ 
    //         LinkedList<Integer> pos = new LinkedList();
    //         while(map.get(A[idx]).size() > 0 && map.get(A[idx]).peekFirst() <= bound){
    //             pos.addFirst(map.get(A[idx]).pollFirst());
    //         }

    //         if(map.get(A[idx]).size() > 0){
    //            int firstBigger = map.get(A[idx]).pollFirst();
    //            helper(A,map,idx+1,res,v+1,firstBigger,maxBound);
    //            map.get(A[idx]).addFirst(firstBigger);
    //         }

    //         for(int t:pos){
    //             map.get(A[idx]).addFirst(t);
    //         }
    //     }

    //     helper(A,map,idx+1,res,v,bound,maxBound);
    // }
}

