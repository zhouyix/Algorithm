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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    
    public TreeNode  helper(int[] preorder,int[] inorder,int pbegin,int pend,int ibegin,int iend)
    {
        if(pbegin <= pend && ibegin<= iend){
            int i = ibegin;
        for(;i<=iend;i++)
          if(preorder[pbegin] == inorder[i])
             break;
             TreeNode root = new TreeNode(preorder[pbegin]);
             root.left = helper(preorder,inorder,pbegin+1,pbegin+i-ibegin,ibegin,i-1);
             root.right = helper(preorder,inorder,pbegin+1+i-ibegin,pend,i+1,iend);
             return root;
        }
        else
        return null;
        
    }
}