/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */
class Solution {
	// change it to the merge K sorted linklist
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int[] idx = new int[nums1.length];
        for(int i=0;i<Math.min(k, nums1.length*nums2.length);i++){
            int cur = 0 , sum = Integer.MAX_VALUE;
            for(int j=0;j<nums1.length;j++){
                if(idx[j] < nums2.length && sum >= nums1[j]+nums2[idx[j]]){
                    cur = j;
                    sum = nums1[j] + nums2[idx[j]];
                }
            }

            ArrayList<Integer> l = new ArrayList<>();
            l.add(nums1[cur]);
            l.add(nums2[idx[cur]]);
            res.add(l);
            idx[cur]++;
        }

        return res;
    }
	
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return nums1[t1[0]]+nums2[t1[1]] - nums1[t2[0]]-nums2[t2[1]];
            }
        });

        for(int i=0;i<nums1.length;i++){
            p.add(new int[]{i,0});
        }

        int count = 0;
        while(count < k && p.size() > 0){
            int[] small = p.poll();
            count++;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[small[0]]);
            list.add(nums2[small[1]]);
            res.add(list);

            if(small[1]+1 < nums2.length){
                p.add(new int[]{small[0],small[1]+1});
            }
        }

        return res;
    }
}

