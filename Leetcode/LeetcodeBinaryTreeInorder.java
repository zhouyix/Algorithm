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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        
        inorder(root,list);
        return list;
    }
    
    void inorder(TreeNode root,List<Integer> list)
    {  
        if(root==null)
           return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}