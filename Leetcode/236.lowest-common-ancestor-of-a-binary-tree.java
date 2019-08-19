/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     List<TreeNode> list1 =new ArrayList<TreeNode>();
    //     List<TreeNode> list2 =new ArrayList<TreeNode>();
    //     findParent(root,p,list1);
    //     findParent(root,q,list2);
    //     return findCommonParent(list1,list2,root);
    // }

    // public boolean findParent(TreeNode root,TreeNode p,List<TreeNode> path){
    //     if(root==p){
    //         path.add(p);
    //         return true;
    //     }

    //     path.add(root);
    //     if(root.left!=null && findParent(root.left, p, path)){
    //       return true;
    //     }


    //     if(root.right!=null && findParent(root.right, p, path)){
    //         return true;
    //      }

    //     path.remove(path.size()-1);
    //     return false;
    // }


    // public TreeNode findCommonParent(List<TreeNode> list1,List<TreeNode> list2,TreeNode root){
    
    //     int i=0,j=0;
    //        while(i<list1.size() && j<list2.size() && list1.get(i)==list2.get(j)){
    //            i++;
    //            j++;
    //        }

    //        return list1.get(i-1);
    //     }

    if(root==null || root==p||root==q){
        return root;
    }

    TreeNode left = lowestCommonAncestor(root.left,p,q);
    TreeNode right = lowestCommonAncestor(root.right,p,q);

    if(left!=null && right!=null){
        return root;
    }

    return left!=null ? left :right;
}
}

