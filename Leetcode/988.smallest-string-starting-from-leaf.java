/*
 * @lc app=leetcode id=988 lang=java
 *
 * [988] Smallest String Starting From Leaf
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
    String min="";
    public String smallestFromLeaf(TreeNode root) {
        helper(root, new StringBuilder());
        return min;
    }

    private void helper(TreeNode curr, StringBuilder sb){
        if(curr == null) return;
        if(curr.left == null && curr.right == null){
            String tmp = (char)(curr.val+'a')+sb.reverse().toString();
            if(min.equals("") || tmp.compareTo(min) < 0)
                min = tmp;
            sb.reverse();
            return;
        }
        sb.append((char)(curr.val+'a'));
        helper(curr.left, sb);
        helper(curr.right, sb);
        sb.setLength(sb.length()-1);
    }

    public String smallestFromLeaf1(TreeNode root) {
        if(root==null){
            return null;
        }

        String[] compare = new String[]{""};
        preorder(root,compare,"");
        return compare[0];
    }

    public void preorder(TreeNode root,String[] compare,String s){
        if(root.left==null && root.right==null){ 
            s = (char)('a'+root.val)+""+s;
            if(compare[0].length() ==0  || s.compareTo(compare[0]) < 0){
                compare[0] = s;
            }

            return;
        }

    
        if(root.left!=null){
              preorder(root.left,compare,((char)('a'+root.val))+""+s);
        }
      
        if(root.right !=null){
                preorder(root.right,compare,((char)('a'+root.val))+""+s);   
        }
    
    }
}

