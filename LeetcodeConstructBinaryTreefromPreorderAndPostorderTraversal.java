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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder,int[] postorder,int ibegin,int iend,int pbegin,int pend)
    {
        if(ibegin <= iend && pbegin <= pend){
           int i = ibegin;
           for(;i<=iend;i++)
              if(postorder[pend] == inorder[i])
                break;
              TreeNode root = new TreeNode(postorder[pend]);
              root.left = helper(inorder,postorder,ibegin,i-1,pbegin,pbegin+i-1-ibegin);
              root.right = helper(inorder,postorder,i+1,iend,pbegin+i-ibegin,pend-1);
              return root;
        }
        else
        return null;
    }
}