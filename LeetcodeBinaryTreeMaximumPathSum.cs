/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int MaxPathSum(TreeNode root) {
        int[] max = new int[1]{int.MinValue};
        helper(root,max);
        return max[0];
    }
    
    public int  helper(TreeNode root, int[] max)
    {
        if(root == null)
        {
            return 0;
        }
        
        helper(root.left,map,max);
        helper(root.right,map,max);
        
        //if < 0 ,abandon the child path sum
        int leftNodeMax =  Math.Max(helper(root.left,max),0) ;
        int rightNodeMax = Math.Max(helper(root.right,max),0);

        max[0] = Math.Max(max[0],root.val+leftNodeMax+rightNodeMax);
        
        //just can return either left path or right path
        return Math.Max(leftNodeMax,rightNodeMax)+root.val;
        
    }
}