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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> pre=new ArrayList<Integer>();
        pre.add(null);
        return helper(root,pre);
    }

    public boolean helper(TreeNode root,ArrayList<Integer> pre)
    {
    	if(root==null)
    		return true;
    	boolean left=helper(root.left,pre);
    	if(pre.get(pre.size()-1)!=null && root.val <= pre.get(pre.size()-1))
    	{
    		return false;
    	}
    	pre.add(root.val);
    	return left && helper(root.right,pre);
    }
}