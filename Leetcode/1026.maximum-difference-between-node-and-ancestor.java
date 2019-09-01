/*
 * @lc app=leetcode id=1026 lang=java
 *
 * [1026] Maximum Difference Between Node and Ancestor
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        // record the min value on left and right for the root 
if(root == null){
    return 0;
}
        int[] res = new int[1];
        postOrder(root,root.val,root.val,res);
        return res[0];
    }

    public void postOrder(TreeNode root,int min,int max,int[] res){
        if(root==null){
            return;
        } 
        res[0] = Math.max(res[0],Math.max(Math.abs(root.val-min),Math.abs(root.val-max)));
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);
        postOrder(root.left,min,max,res);
        postOrder(root.right,min,max,res);
    }
}

