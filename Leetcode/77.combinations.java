

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        helper(res,n,k,1,new ArrayList());
        return res;
    }

   public void helper(List<List<Integer>> res,int n,int k,int idx,List<Integer> li){
       if(li.size()==k){
           res.add(new ArrayList(li));
           return;
       }

       for(int i=idx;i<=n;i++){
           li.add(i);
           helper(res,n,k,i+1,li);
           li.remove(li.size()-1);
       }
   }
}

