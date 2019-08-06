/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */
class NumArray {

    int[] tree;
    int n ;
    public NumArray(int[] nums) {
      n = nums.length;
      tree = new int[nums.length * 4];
      build(nums,0,n-1,0);
    }

    public int  build(int[] nums,int l,int h,int idx){
        if(l > h){
            return 0;
        }
        
        if(l==h){
            tree[idx] = nums[l];
            return tree[idx];
        }

        int mid = l +(h-l)/2;
        tree[idx] =  build(nums,l,mid,idx*2+1) +  build(nums,mid+1,h,idx*2+2);
        return tree[idx];
    }

    public void update(int i, int val) {
        update(0,n-1,i,val,0);
    }

    public void update(int l,int h,int i,int val,int idx){
        if(l==h && i == l){
            tree[idx] = val;
            return;
        }

        if(i < l || i > h){
            return;
        }

        int mid = l +(h-l)/2;
        if(i <= mid){
            update(l,mid,i,val,idx*2+1);
        }else{
            update(mid+1,h,i,val,idx*2+2);
        }

        tree[idx] = tree[idx*2+1]+ tree[idx*2+2];
    }

    public int sumRange(int i, int j) {
        return sumRange(0, n-1, i, j, 0);
    }

    public int sumRange(int l,int h,int i,int j,int idx){
        if(i > h || j < l){
            return 0;
        }

        if (i <= l && j >= h)
            return tree[idx];

        int mid =l +(h-l)/2;
        return sumRange(l, mid, i, j, 2 * idx + 1) +
                sumRange(mid + 1, h, i, j, 2 * idx + 2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

