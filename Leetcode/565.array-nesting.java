/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */
class Solution {
    public int arrayNesting0(int[] nums) {
        int i=0,res=0;
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int j=0;j<nums.length;j++){
           map.put(nums[j],j);
       }

       HashSet<Integer> v = new HashSet<>();
       while(i<nums.length){
           if(nums[i] >= nums.length || !map.containsKey(i) || v.contains(nums[i])){
               i++;
               continue;
           }

           int size = v.size();
           v.add(nums[i]);
           v.add(i);
           int idx = i;
           while(map.containsKey(idx)){
               if(v.contains(map.get(idx))){
                   res = Math.max(res,v.size()-size);
                   break;
               }else if(map.get(idx) >= nums.length){
                   break;
               }
               else{
                   v.add(map.get(idx));
                   idx = map.get(idx);
               }
           }

       }
       return res;
    }

    public int arrayNesting1(int[] nums) {
        int i=0,res=0;
    HashSet<Integer> v = new HashSet<>();
    for(;i<nums.length;i++){
        if(v.contains(nums[i]))
          continue;

        res = Math.max(res,helper(nums,i,v));
    }

       return res;
    }

    public int helper(int[] nums,int start,HashSet<Integer> v){
        int i=start;
        int res =0;
        while(res==0 || i!=start){
            v.add(i);
            i = nums[i];
            res++;
        }

        return res;
    }

    public int arrayNesting(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            int c=1;
            while(nums[i]!=i){
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;

                c++;
            }

            res = Math.max(res,c);
        }

        return res;
    }
}

