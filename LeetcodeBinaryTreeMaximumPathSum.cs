/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int MaxPathSum(TreeNode root) {
        Dictionary<TreeNode,int[]> map = new Dictionary<TreeNode,int[]>();
        int[] max = new int[1]{int.MinValue};
        helper(root,map,max);
        return max[0];
    }
    
    public void helper(TreeNode root, Dictionary<TreeNode,int[]> map,int[] max)
    {
        if(root == null || map.ContainsKey(root))
        {
            return;
        }
        
        helper(root.left,map,max);
        helper(root.right,map,max);
        
        int leftNodeMax = root.left != null  ? Math.Max(map[root.left][0],map[root.left][1]) + root.left.val : 0;
        int rightNodeMax =root.right != null ? Math.Max(map[root.right][0],map[root.right][1]) + root.right.val:0;
        map.Add(root,new int[]{leftNodeMax < 0 ? 0 : leftNodeMax,rightNodeMax < 0 ? 0:rightNodeMax});
        
        int sum = Math.Max(root.val,root.val+(leftNodeMax >0 ? leftNodeMax : 0)+(rightNodeMax >0 ? rightNodeMax : 0));
        if(sum > max[0])
            max[0] = sum;
        
    }
}