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
    public void recoverTree(TreeNode root) {
        TreeNode one = root,two = root;
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        helper(pre,list,root);
        int tmp = list.get(0).val;
        list.get(0).val = list.get(1).val;
        list.get(1).val = tmp;
    }
    
    public void helper( ArrayList<TreeNode> pre, ArrayList<TreeNode> list,TreeNode root){
        if(root == null)
           return;
        helper(pre,list,root.left);
        if(pre.get(0) != null && pre.get(0).val > root.val)
           {
               if(list.size()==0)
                 {
                     list.add(pre.get(0));
                     list.add(root);
                 }
                 else
                 {
                     list.set(1,root);
                 }
           }
           pre.set(0,root);
         helper(pre,list,root.right);
        }
}