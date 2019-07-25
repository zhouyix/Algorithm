import java.util.List;

/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
       
       List<List<Integer>> res = new ArrayList<>();

        if(nums.length == 0)
        return res;

        dfs(new ArrayList<Integer>(),res,nums,0);
        return res;
    }

    public void dfs(List<Integer> list,List<List<Integer>> res,int[] nums,int index){
        if(list.size() > 1){
            res.add(new ArrayList<>(list));
        }
         HashSet<Integer> set = new HashSet<>();
         for(int i=index;i<nums.length;i++){
             if(!set.add(nums[i])) continue;
             if(list.size()==0 || list.get(list.size()-1) <= nums[i]){
              list.add(nums[i]);
              dfs(list,res,nums,i+1);
              list.remove(list.size()-1);
          }
         }
    }
}

