/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<TreeNode> res = new ArrayList<>();
       LinkedList<TreeNode[]> q = new LinkedList<>();
       q.add(new TreeNode[]{root,root});
       if(!contains(root,to_delete)){
           res.add(root);
       }

       int count = to_delete.length;
       while(!q.isEmpty() && count > 0){
           int size = q.size();
           while(size > 0){
               TreeNode[] node = q.poll();
               boolean isDelete = contains(node[0],to_delete);
               if(isDelete) count--;
                   if(node[0].left!=null){
                       if(isDelete && !contains(node[0].left,to_delete))
                           res.add(node[0].left);
                       q.add(new TreeNode[]{node[0].left,node[0]});
                   }

                   if(node[0].right!=null){
                       if(isDelete && !contains(node[0].right,to_delete))
                           res.add(node[0].right);
                       q.add(new TreeNode[]{node[0].right,node[0]});
                   }
                   
                   if(isDelete){
                       if(node[1].left == node[0]){
                           node[1].left = null;
                       }else{
                           node[1].right = null;
                       }
                   }

                   size--;
               }
           }

          return res;
       }

    public boolean contains(TreeNode node,int[] arr){
        for(int v : arr){
            if(node.val == v){
                return true;
            }
        }

        return false;
    }
}

