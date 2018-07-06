public class Solution {
    public bool IsValidBST(TreeNode root) {
     return IsValid(root,long.MinValue,long.MaxValue);
    }
    
    public bool IsValid(TreeNode root, long min,long max)
    {
       
       if ( root == null)
                return true;
       
          if(root.val > min && root.val < max)
           {
              return IsValid(root.left,min,root.val) && IsValid(root.right,root.val,max);
           }
        
          return false;
         
    }
}