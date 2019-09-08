/*
 * @lc app=leetcode id=971 lang=java
 *
 * [971] Flip Binary Tree To Match Preorder Traversal
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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        int[] i = new int[]{0};
          preorder(root,voyage,res,i,null);
          if(i[0] == Integer.MAX_VALUE || i[0] < 0){
              res.clear();
              res.add(-1);
          }
              return res;
          
    }

    public void preorder(TreeNode root,int[] v, List<Integer> res,int[] i,TreeNode parent){
        if(i[0]==Integer.MAX_VALUE || i[0] < 0){
            return;
        }

        if(root.val!=v[i[0]]){
            if((parent!=null && parent.left == root && parent.right!=null && parent.right.val == v[i[0]]) ||
            (parent!=null && parent.right == root && parent.left!=null && parent.left.val == v[i[0]])){
                TreeNode tmp = parent.left;
                parent.left = parent.right;
                parent.right =tmp;
                res.add(parent.val);
                root = parent.left;
            }else{
                i[0] = Integer.MAX_VALUE;
                return;
           }
        }
           
        if(root.left!=null){
            i[0]++;
               preorder(root.left,v,res,i,root);
        }
        if(root.right!=null){
            i[0]++;
            preorder(root.right,v,res,i,root);
        }
                
        
    }

}

