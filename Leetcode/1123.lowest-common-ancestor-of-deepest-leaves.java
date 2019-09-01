/*
 * @lc app=leetcode id=1123 lang=java
 *
 * [1123] Lowest Common Ancestor of Deepest Leaves
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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null){
            return root;
        }

        TreeNode[] res = new TreeNode[1];
        res[0] = root;
        treeHight(root,root,res);
       return res[0];
    }

    public int treeHight(TreeNode parent,TreeNode root,TreeNode[] res){
        if(root==null){
            res[0] = parent;
            return 0;
        }

        if(root.left == null && root.right == null){
            res[0] = root;
            return 1;
        }
        
    
        int left =  treeHight(root,root.left,res);
        TreeNode leftRes = res[0];

        int right = treeHight(root,root.right,res);
        if(left > right){
            res[0] = leftRes;
        }else if(left == right){
            res[0] = root;
        }

        return 1 + Math.max(left,right);
    }
}

