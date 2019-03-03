public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums.length==0)
           return lists;
           Arrays.sort(nums);
         lists.add(new ArrayList<Integer>());
        helper(lists,new ArrayList<Integer>(),0,nums);
        return lists;
    }
    
    public void helper( ArrayList<List<Integer>> lists, ArrayList<Integer> list,int start,int[] nums){
        if(start == nums.length)
          {
              return;
          }
          
          for(int i=start;i<nums.length;i++){
              if(i>start && nums[i]==nums[i-1])
                continue;
              list.add(nums[i]);
              lists.add(new ArrayList<Integer>(list));
              helper(lists,list,i+1,nums);
              list.remove(list.size()-1);
          }
    }
}