/*
 * @lc app=leetcode id=998 lang=java
 *
 * [998] Maximum Binary Tree II
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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
       if(root==null)
       return root;

        return insert(root,new TreeNode(val));
    }

    public TreeNode insert(TreeNode root,TreeNode add){
        if(root==null){
            return add;
        }

       if(root.val < add.val){
           add.left = root;
           return add;
       }

       root.right = insert(root.right,add);
       return root;
    }
}

