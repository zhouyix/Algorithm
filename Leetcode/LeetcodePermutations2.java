public class Solution {
   public  IList<IList<int>> PermuteUnique(int[] nums)
        {
            List<IList<int>> res = new List<IList<int>>();
       Array.Sort(nums);
            dfs(nums, res, new List<int>(), new bool [nums.Length]);
            return res;                                                                                 
        }

        public  void dfs(int[] nums,List<IList<int>> res,List<int> list,bool[] visited)
        {
            if(nums.Length == list.Count)
            {
                res.Add(new List<int>(list));
                return;
            }

            for(int i=0;i<nums.Length;i++)
            {
                if (visited[i])
                    continue;
                if ( i > 0&&!visited[i-1]  && nums[i - 1] == nums[i])
                    continue;

                list.Add(nums[i]);
                visited[i] = true;
                dfs(nums, res, list, visited);
                visited[i] = false;
                list.RemoveAt(list.Count - 1);
            }
        }
}