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
    public TreeNode ConvertBST(TreeNode root) {
        List<TreeNode> list = new List<TreeNode>();
        InOrder(root,new int[1]);
        
       
        
        return root;
    }
    
    public void InOrder(TreeNode root,int[] sum)
    {
        if(root == null)
            return;
        
        InOrder(root.right,sum); 
        int tmp = root.val;
        root.val = root.val + sum[0];
       
        sum[0] = sum[0] +tmp;
        InOrder(root.left,sum);
    }
}