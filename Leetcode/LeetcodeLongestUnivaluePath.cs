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
    public int LongestUnivaluePath(TreeNode root) {
        int[] sum = new int[1];
        PostOrder(root,sum);
        return sum[0];
    }
    
    public int PostOrder(TreeNode root,int[] sum)
    {
        if(root == null)
            return 0;
        int left = PostOrder(root.left,sum);
        int right = PostOrder(root.right,sum);
        
       
        if(root.left!=null && root.left.val == root.val)
        {
            left =  left + 1;
           
        } 
        else
             left = 0;
        if(root.right!=null && root.right.val == root.val)
        {
            right = right + 1;
            
        } 
        else
            right = 0;
        
         var res = Math.Max(left,right);
         sum[0] = Math.Max(sum[0],left+right);
        
        return res;
        
    }
}