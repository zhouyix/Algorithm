public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m + n) / 2;
        if((m+n)%2==0){
            return (findKth(nums1,nums2,0,0,m,n,k)+findKth(nums1,nums2,0,0,m,n,k+1))/2;
        }   else {
            return findKth(nums1,nums2,0,0,m,n,k+1);
        }

    }

    private double findKth(int[] arr1, int[] arr2, int start1, int start2, int len1, int len2, int k){
        if(len1>len2){
            return findKth(arr2,arr1,start2,start1,len2,len1,k);
        }
        if(len1==0){
            return arr2[start2 + k - 1];
        }
        if(k==1){
            return Math.min(arr1[start1],arr2[start2]);
        }
        int p1 = Math.min(k/2,len1) ;
        int p2 = k - p1;
        if(arr1[start1 + p1-1]<arr2[start2 + p2-1]){
            return findKth(arr1,arr2,start1 + p1,start2,len1-p1,len2,k-p1);
        } else if(arr1[start1 + p1-1]>arr2[start2 + p2-1]){
            return findKth(arr1,arr2,start1,start2 + p2,len1,len2-p2,k-p2);
        } else {
            return arr1[start1 + p1-1];
        }
    }
}