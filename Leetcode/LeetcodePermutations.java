public class Solution {
     public  IList<IList<int>> Permute(int[] nums)
        {
            List<IList<int>> res = new List<IList<int>>();
            int sum = 1;
            int i = nums.Length;
            while(i>0)
            {
                sum = sum * i;
                i--;
            }

            int count = 0;
            while(count < sum)
            {
                count = count + nextPermutation(res, nums);
            }

            return res;                                                                                 
        }
        public  int nextPermutation(IList<IList<int>> res,int[] nums)
        {
            List<int> result = new List<int>();
            foreach(var item in nums)
            {
                result.Add(item);
            }
            if(result.Count>0)
                res.Add(result);

            int firstDown = nums.Length - 2;
            while (firstDown >= 0 && nums[firstDown] >= nums[firstDown + 1])
                firstDown--;
            if (firstDown == -1)
            {
                int i = 0, j = nums.Length - 1;
                while (i < j)
                {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;

                    i++;
                    j--;
                }

               
                return 1;
            }

            int minBigger = nums.Length-1;
            while(nums[minBigger] <= nums[firstDown])
            {
                minBigger--;
            }

            int tmp2 = nums[firstDown];
            nums[firstDown] = nums[minBigger];
            nums[minBigger] = tmp2;

            Array.Sort(nums, firstDown+1,nums.Length - firstDown-1);
            return 1;
        }
}