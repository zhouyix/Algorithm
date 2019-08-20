/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null){
            return  res;
        }

        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);
        int size=q.size();
        while(size>0){
            int i=0;
            res.add(q.get(q.size()-1).val);
            while(i<size){
                TreeNode node = q.remove(0);
                if(node.left!=null){
                    q.add(node.left);
                }

                if(node.right!=null){
                    q.add(node.right);
                }
                
                i++;
            }

            size = q.size();
        }

        return res;

    }
}

