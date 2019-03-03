public class Solution {
   public bool CanPartition(int[] nums)
        {
           int sum = 0,n=nums.Length;
        int i, j;
 
        // Caculcate sun of all elements
        for (i = 0; i < n; i++)
            sum += nums[i];
 
        if (sum % 2 != 0)
            return false;
 
        bool [, ]part=new bool[sum / 2 + 1, n + 1];
 
        // initialize top row as true
        for (i = 0; i <= n; i++)
            part[0, i] = true;
 
        // initialize leftmost column, except 
        // part[0][0], as 0
        for (i = 1; i <= sum/2; i++)
            part[i, 0] = false;
 
        // Fill the partition table in botton 
        // up manner
        for (i = 1; i <= sum/2; i++)
        {
            for (j = 1; j <= n; j++)
            {
                part[i, j] = part[i, j - 1];
                if (i >= nums[j - 1])
                    part[i, j] = part[i, j] ||
                    part[i - nums[j - 1],j - 1];
            }
        }
 
 
        return part[sum / 2, n];
        }

        public bool Dfs(int[] nums,int i,int sum)
        {
            if (i>=0 && sum == 0)
            {
                return true;
            }
            
            if(i == 0 && sum!=0)
            {
                return false;
            }

            if(nums[i-1] > sum)
                return Dfs(nums,i-1,sum);
            
            return Dfs(nums,i-1,sum) || Dfs(nums,i-1,sum-nums[i-1]);
        }
}