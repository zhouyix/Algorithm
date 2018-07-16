 public int merge(int[] sum, int mid, int left, int right)
        {
            int[] tmp = new int[right - left + 1];
            int k = 0, ll = left, rr = mid + 1;
            int count = 0;
            int i=left,j=mid+1;
           while(i<=mid && j<=right)
           {
               if(sum[i]/2.0 > sum[j])
               {
                   count = count + mid-i+1;
                   j++;
               }
               else
                   i++;
           }

          
            while (ll <= mid && rr <= right)
            {
                if (sum[ll] > sum[rr])
                {

                    tmp[k++] = sum[rr++];

                }

                else
                    tmp[k++] = sum[ll++];


            }

            while (ll <= mid)
                tmp[k++] = sum[ll++];
            while (rr <= right)
                tmp[k++] = sum[rr++];

            for ( i = left; i <= right; i++)
            {
                sum[i] = tmp[i - left];
            }

            return count;
        }

        public int ReversePairs(int[] nums)
        {

            return mergeSort(nums, 0, nums.Length - 1);
        }
        public int mergeSort(int[] nums, int left, int right)
        {
            if (left >= right)
                return 0;
            int mid = (left + right) / 2;
            int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);



            count += merge(nums, mid, left, right);
            return count;

        }
