
/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        helper(nums,res,new ArrayList<Integer>(),0);
        return res;
    }

    public void helper(int[] nums,List<List<Integer>> res,List<Integer> li,int idx){ 
        res.add(new ArrayList(li));
        if(idx==nums.length){
            return;
        }
       
        for(int i=idx;i<nums.length;i++){
            li.add(nums[i]);
            helper(nums, res, li, i+1);
            li.remove(li.size()-1);
        }
    }
}

