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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists=new ArrayList<List<Integer>>();  
        if(root!=null)
         {
         	ArrayList<TreeNode> pre=new ArrayList<TreeNode>();
             pre.add(root);
         	 helper(lists,pre,1);
         }
    	 
        return lists;
    }

    public void helper(List<List<Integer>> lists,ArrayList<TreeNode> pre,int preLayer)
    {
       	ArrayList<TreeNode> newPre=new ArrayList<TreeNode>();
        if(pre.size()!=0)
        {
            ArrayList<Integer> list=new ArrayList<Integer>();
           if(preLayer%2==1){
        	for(int i=0;i<pre.size();i++)
        	{
                list.add(pre.get(i).val);
                if(pre.get(pre.size()-1-i).right!=null)
                	newPre.add(pre.get(pre.size()-1-i).right);
                if(pre.get(pre.size()-1-i).left!=null)
                	newPre.add(pre.get(pre.size()-1-i).left);
               
        	}
        	lists.add(list); 
        	}
        	else
        	{
        	    for(int i=0;i<pre.size();i++)
             	{
                  list.add(pre.get(i).val);
               
                  if(pre.get(pre.size()-1-i).left!=null)
                	newPre.add(pre.get(pre.size()-1-i).left);
                   if(pre.get(pre.size()-1-i).right!=null)
                	newPre.add(pre.get(pre.size()-1-i).right);
               
        	     }
        	    lists.add(list); 
        	}
        	
        	helper(lists,newPre,preLayer+1);  
        }
    }
}