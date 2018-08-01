  public int SmallestDistancePair(int[] nums, int k)
        {
            Array.Sort(nums);
            int maxGap = nums[nums.Length - 1] - nums[0];
            int[] gap = new int[maxGap + 1];
            for (int i = 0; i < nums.Length; i++)
            {
                for (int j = i + 1; j < nums.Length; j++)
                {
                    gap[nums[j] - nums[i]]++;
                }
            }

            for (int i = 0; i < gap.Length; i++)
            {
                k = k - gap[i];
                if (k <= 0)
                    return i;
            }
            return -1;
        }
