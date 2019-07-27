/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count =0;
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        for(int i=0;i<A.length;i++)
          for(int j=0;j<B.length;j++){
              int low = 0;
              int high = D.length-1;
              while(low < C.length && high >=0){
                  int sum = A[i]+B[j]+C[low]+D[high];
                  if(sum==0){
                      int tmp = low,tmp2=high;
                      while(low+1<C.length && C[low+1] == C[low]){
                        low++;
                      }

                      while(high-1>=0 && D[high-1] == D[high]){
                        high--;
                      }
                     
                      count= count + (low-tmp+1)*(tmp2-high+1);
                      low++;
                      high--;
                  }else if(sum >0 ){
                      high--;
                  }else{
                      low++;
                  }
              }
          }

          return count;
    }
}

