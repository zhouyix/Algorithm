Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
        	return null;
        TreeNode root=helper(nums,0,nums.length-1);
        return root;
        
    }

    public TreeNode helper(int[] nums,int l,int r){
    	if(l <= r)
    	{
    		int mid = (l+r)/2;
    		TreeNode node = new TreeNode(nums[mid]);
    		node.left = helper(nums,l,mid-1);
    		node.right = helper(nums,mid+1,r);
    		return node;
    	}
    	return null;
    }
}