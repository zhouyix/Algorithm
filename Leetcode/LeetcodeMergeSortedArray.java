public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       
        int[] arr=new int[m+n];
        int k=0,i=0,j=0;
        
        while(i < m && j <n)
        {
            if(nums1[i] < nums2[j])
              {
                  arr[k++]=nums1[i];
                  i++;
              }
             else
             {
                 arr[k++]=nums2[j];
                 j++;
             }
        }
        
        while( i< m)
        {
            
             arr[k++]=nums1[i++];
        }
          
        
        while(j < n)
        {
             arr[k++]=nums2[j++];
        }
          
           
           
        for(int t=0;t<m+n;t++)
        {
            nums1[t]=arr[t];
        }
    }
}