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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists=new ArrayList<List<Integer>>();  
        if(root!=null)
         {
         	ArrayList<TreeNode> pre=new ArrayList<TreeNode>();
             pre.add(root);
         	 helper(lists,pre);
         }
    	 
        return lists;
    }

    public void helper(List<List<Integer>> lists,ArrayList<TreeNode> pre)
    {
    	ArrayList<TreeNode> newPre=new ArrayList<TreeNode>();
        if(pre.size()!=0)
        {
        	ArrayList<Integer> list=new ArrayList<Integer>();
        	for(int i=0;i<pre.size();i++)
        	{
                list.add(pre.get(i).val);
                if(pre.get(i).left!=null)
                	newPre.add(pre.get(i).left);
                if(pre.get(i).right!=null)
                	newPre.add(pre.get(i).right);
        	}
        	lists.add(list); 
        	helper(lists,newPre);  
        }
        
       
    }
}