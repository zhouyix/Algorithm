/*
 * @lc app=leetcode id=967 lang=java
 *
 * [967] Numbers With Same Consecutive Differences
 */
class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        ArrayList<Integer> list = new ArrayList();
        if(N==1){
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }

        for(int i=1;i<=9;i++){
            helper(N-1,i,K,list);
        }


        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }

        return res;
    
    }

    public void helper(int N,int v,int K,ArrayList<Integer> res){
        if(N==0){
            res.add(v);
            return;
        }

        int last = v%10;
        if(last+K < 10){
            helper(N-1,v*10+last+K,K,res);
        }

        if(K!=0 && last-K>=0){
            helper(N-1,v*10+last-K,K,res);
        }
    }
}

