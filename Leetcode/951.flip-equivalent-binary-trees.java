/*
 * @lc app=leetcode id=951 lang=java
 *
 * [951] Flip Equivalent Binary Trees
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null){
            return true;
        }

        if(root1==null || root2==null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        if(root1.left!=null && root2.left==null){
            swap(root1);
        }else if(root1.left == null && root2.left !=null){
            swap(root1);
        }else if(root1.left!=null && root2.left!=null && root1.left.val!=root2.left.val){
            swap(root1);
        }

        return flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right);

    
    }

    public void swap(TreeNode t1){
        TreeNode tmp = t1.left;
        t1.left = t1.right;
        t1.right = tmp;
    }

}

