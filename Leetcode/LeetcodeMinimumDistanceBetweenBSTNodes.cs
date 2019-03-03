public class Solution {
    public int MinDiffInBST(TreeNode root) {
       List<int> res = new List<int>();
       InOrder(root,res);
        int min = root.val;
        for(int i=1;i<res.Count;i++)
        {
            min = Math.Min(min,res[i]-res[i-1]);
        }
        
        return min;
     
    }
    
    public void InOrder(TreeNode root,List<int> res)
    {
        if(root == null)
            return;
        
        InOrder(root.left,res);
        res.Add(root.val);
        InOrder(root.right,res);
    }
}