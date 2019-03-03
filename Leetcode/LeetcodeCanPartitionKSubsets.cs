public class Solution {
    public bool CanPartitionKSubsets(int[] nums, int k) {
      int sum = 0;
            foreach (var item in nums)
            {
                sum += item;
            }

            if (sum % k != 0)
                return false;
            Array.Sort(nums);
           return Dfs(0,nums,0,sum/k,new bool[nums.Length],k);
        }
    
     public bool Dfs(int start, int[] nums, int parSum, int sum,bool[] visited,int k)
        {
            if (k == 1)
                return true;
            if (start == nums.Length)
                return false;
            if (sum < parSum)
                return false;
            if (sum == parSum)
                return Dfs(0, nums, 0, sum, visited, k - 1);
            for (int i = start; i < nums.Length; i++)
            {
                if (visited[i])
                    continue;
                visited[i] = true;
                if (Dfs(i + 1, nums, parSum + nums[i], sum, visited, k))
                    return true;
                visited[i] = false;
            }

            return false;
        }

//this could cause TimeOut
        public bool Dfs(int index,int[] nums,int sum,int[] bucket)
        {
            if(index == nums.Length)
            {
                foreach(var i in bucket)
                {
                    if(i!=sum)
                    return false;
                }
                return true;
            }

            for(int i=0;i<bucket.Length;i++)
            {
                if(bucket[i]+nums[index] <= sum)
                   {
                     bucket[i] = bucket[i]+nums[index];
                     if(Dfs(index+1,nums,sum,bucket))
                       return true;
                    bucket[i] = bucket[i]-nums[index];
                   }
            }
        }
}