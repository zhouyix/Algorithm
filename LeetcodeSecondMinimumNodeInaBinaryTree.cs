public class Solution {
    public int FindSecondMinimumValue(TreeNode root) {
        
        return FindSecond(root,root.val);
    }
    
    public int FindSecond(TreeNode root,int first)
    {
        if(root == null)
        {
            return -1;
        }
        
       if(root.val != first)
           return root.val;
        
        
           var left = FindSecond(root.left,first);
        
           var right = FindSecond(root.right,first);
       
        return (left == -1 || right == -1) ? Math.Max(left,right) : Math.Min(left,right);
    }
}