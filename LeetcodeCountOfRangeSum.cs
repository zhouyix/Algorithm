public class Solution {
    public int CountRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.Length+1];
        for(int i=1;i<sum.Length;i++)
        {
            sum[i]=sum[i-1]+nums[i-1];
        }
        
        return mergeSort(sum,lower,upper,0,sum.Length-1);
    }
    
    public int mergeSort(long[] sum,int lower,int upper,int left,int right)
    {
        if(left >= right)
            return 0;
        int mid = (left+right)/2;
        int count = mergeSort(sum,lower,upper,left,mid)+mergeSort(sum,lower,upper,mid+1,right);
        for(int t = mid+1;t<=right;t++)
        {
            int begin =left,end=left;
            while(begin <= mid && sum[t]-sum[begin] >= lower)
                 begin++;
            while(end <= mid && sum[t]-sum[end] > upper)
                end++;
            count += begin-end;
         }
        
        merge(sum,mid,left,right);
        return count;   
    }
    
    public void merge(long[] sum,int mid,int left,int right)
    {
        long[] tmp = new long[right-left+1];
        int k=0,ll=left,rr=mid+1;
        while(ll<=mid && rr<=right)
        {
            if(sum[ll] < sum[rr])
                tmp[k++]=sum[ll++];
            else
                tmp[k++]=sum[rr++];
        }
        
        while(ll<=mid)
             tmp[k++]=sum[ll++];
        while(rr<=right)
             tmp[k++]=sum[rr++];
        
        for(int i=left;i<=right;i++)
        {
            sum[i] = tmp[i-left];
        }
    }
}