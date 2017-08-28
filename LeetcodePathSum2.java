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
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> lists=new ArrayList<List<Integer>>();
        if(root == null)
        	return lists;
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(root,lists,sum,list);
        return lists;
    }

    public void helper(TreeNode root,List<List<Integer>> lists,int sum,ArrayList<Integer> list)
    {
    	if(root==null)
    		return;
    	
        list.add(root.val);
    	if(root.left==null && root.right==null&& root.val==sum)
    	{
    		lists.add(new ArrayList<Integer>(list));
    		
    	
    	}
    	 helper(root.left,lists,sum-root.val,list); 
    	 helper(root.right,lists,sum-root.val,list); 
    	 list.remove(list.size()-1);
    	 
    }
}