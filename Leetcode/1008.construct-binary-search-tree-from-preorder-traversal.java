/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0){
            return null;
        }

      return buildTree(preorder,0,preorder.length-1);
    }

    public TreeNode buildTree(int[] preorder,int s,int e){
        if(s<=e){
            TreeNode root = new TreeNode(preorder[s]);
            int j=s+1;
            while(j < preorder.length && preorder[j] < root.val){
                j++;
            }

            root.left = buildTree(preorder,s+1,j-1);
            root.right = buildTree(preorder,j,e);

            return root;
        }

        return null;
    }


}

