/*
 * @lc app=leetcode id=1038 lang=java
 *
 * [1038] Binary Search Tree to Greater Sum Tree
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
    public TreeNode bstToGst(TreeNode root) {
        // RNL order
        rightNodeLeft(root,new int[1]);
        return root;
    }

    public void rightNodeLeft(TreeNode root,int[] sum){
        if(root == null){
            return;
        }

        rightNodeLeft(root.right,sum);
        root.val = root.val + sum[0];
        sum[0]=root.val;
        rightNodeLeft(root.left,sum);
    }
}

