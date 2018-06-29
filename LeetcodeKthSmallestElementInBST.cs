public class Solution {
    public int KthSmallest(TreeNode root, int k) {
            
       int[] res = new int[2];
       Inorder(root,k,res);
       return res[1];
    }
    
    public void Inorder(TreeNode root,int count,int[] res)
{
     if(root == null)
    {
      return;
    }

    Inorder(root.left,count,res);
    res[0] =res[0] +1;
    if(count == res[0])
    {
    res[1] = root.val;
    return;
    }
        Inorder(root.right,count,res);}
}