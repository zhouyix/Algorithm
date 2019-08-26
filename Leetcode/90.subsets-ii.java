/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, nums, 0, new ArrayList<Integer>());
        return res;
    }

    public void helper(List<List<Integer>> res, int[] nums, int idx, List<Integer> li) {
        if (idx <= nums.length) {
            res.add(new ArrayList<>(li));
        }

        for (int i = idx; i < nums.length; i++) {
            li.add(nums[i]);
            helper(res, nums, i + 1, li);
            li.remove(li.size() - 1);

            while(i<nums.length-1 && nums[i+1]==nums[i])
                ++i;
        }
    }
}

