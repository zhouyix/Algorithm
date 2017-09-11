/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
     public void connect(TreeLinkNode root) {
       if(root == null)
         return;
        ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        list.add(root);
        helper(list);
    }

    public void helper( ArrayList<TreeLinkNode> list)
    {
    	int i = 0 ,size = list.size();
    	ArrayList<TreeLinkNode> li = new ArrayList<TreeLinkNode>();
    	while(i < size)
    	{
    		TreeLinkNode tmp = list.get(i);
    		if(i+1 < size)
    			tmp.next = list.get(i+1);
    		else
    			tmp.next = null;

    		if(tmp.left != null)
    			li.add(tmp.left);
    		if(tmp.right != null)
    			li.add(tmp.right);
    		i++;
    	}
    		if(li.size()>0)
    	helper(li);
    }
}