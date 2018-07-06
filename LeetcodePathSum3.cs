public class Solution {
   public int PathSum(TreeNode root, int sum) {
       
     if(root == null)
         return 0;
     return DFS(root,sum) + PathSum(root.left,sum)+PathSum(root.right,sum);
    
    }
    
   
    
    public int DFS(TreeNode root,int sum)
    {
        int count =0;
        if(root == null)
            return count;
        if(root.val == sum)
        {
           count++;
        }
       
        count+= DFS(root.left,sum-root.val);
        count+= DFS(root.right,sum-root.val);
        
        return count;
            
    }
}