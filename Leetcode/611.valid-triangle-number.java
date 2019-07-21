/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 */
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=2;i<nums.length;i++){
            int low= 0;
            int high = nums.length-i;
            while(low < high){
                if(nums[low]+nums[high] <= nums[nums.length-i+1]){
                    low++;
                }else{
                    sum = sum + high - low;
                    high--;
                }
            }
        }
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i] == 0){
        //         continue;
        //     }

        //     for(int j=i+1;j<nums.length-1;j++){
        //        int k = binarySearch(nums[i]+nums[j]-1, j+1, nums);
        //        if(k > j){
        //            sum = sum +k-j;
        //        }
        //     }
        // }

        return sum;
    }

    public int binarySearch(int value,int low,int[] nums){
        int high = nums.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == value){
                 while(mid+1 < nums.length && nums[mid+1]==value)
                   mid = mid + 1;

                 return mid;
            }
              
            if(nums[mid] < value){
                 low = mid +1;
            } else{
                high = mid -1;
            }
        }

        return high;
    }
}

