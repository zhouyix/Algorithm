/*
 * @lc app=leetcode id=969 lang=java
 *
 * [969] Pancake Sorting
 */
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        int len=0;
        ArrayList<Integer> res = new ArrayList();
        while(len<A.length){
            int max = 0;
            int j=0;
            while(j<A.length-len){
                if(A[j] > A[max]){
                    max = j;
                }

                j++;
            }

           
                rev(A,0,max);
                if(0!=max){
                    res.add(max+1);
                }
               
                rev(A,0,A.length-len-1);
                if(0!=A.length-len-1){
                     res.add(A.length-len);
                }
              
                len++;
            
        }

        return res;
    }

    public void  rev(int[] A,int s,int e){
        while(s<e){
            int a= A[s];
            A[s] = A[e];
            A[e] = a;
            s++;
            e--;
        }
    }
}

