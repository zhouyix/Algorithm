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
    public List<TreeNode> generateTrees(int n) {
     if(n==0)
       return new ArrayList<TreeNode>();
    return helper(1,n);   
    
 }
 public ArrayList<TreeNode> helper( int l,int r)
 {
 	ArrayList<TreeNode> list = new ArrayList<TreeNode>();
 	if(l > r)
 	{
 		list.add(null);
 		return list;

 	}

 	for(int i = l ;i<=r;i++)
 	{
 		ArrayList<TreeNode> left = helper(l,i-1);
 		ArrayList<TreeNode> right = helper(i+1,r);
 		for(int j =0 ; j <left.size();j++)
 			for(int k =0;k<right.size();k++)
 			{
 				TreeNode root = new TreeNode(i);
 				root.left = left.get(j);
 				root.right = right.get(k);
 				list.add(root);
 			}
 	}
 	 return list;
 }
}