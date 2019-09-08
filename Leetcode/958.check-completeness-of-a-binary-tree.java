/*
 * @lc app=leetcode id=958 lang=java
 *
 * [958] Check Completeness of a Binary Tree
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
    public boolean isCompleteTree(TreeNode root) {
       if(root==null){
           return true;
       }

     return  isValid(root,0,getCount(root)); 
    }

    public int getCount(TreeNode node){
        if(node==null)
          return 0;

        return getCount(node.left)+getCount(node.right)+1;
    }

    public boolean isValid(TreeNode root,int idx,int count){
        if(root == null)
          return true;

          if(idx >= count){
              return false;
          }
    
        
        return isValid(root.left,idx*2+1,count) && isValid(root.right,idx*2+2,count);
    }
}

