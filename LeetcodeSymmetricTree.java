/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
    	if(root==null)
    		return true;
       return  isSym(root.left,root.right);
    }

     public boolean isSym(TreeNode left,TreeNode right)
     {
     if(left == null && right == null)
     		return true;
     	if(left != null && right != null && left.val == right.val)
     	{
            return isSym(left.right,right.left) && isSym(left.left ,right.right);
     	}
     		return false;
     }
}