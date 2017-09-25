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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
           return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(root,list);
        return sum;
    }
    
      public void helper(TreeNode root,ArrayList<Integer> list){
          if(root == null)
              return;
        list.add(root.val);
        if(root.left == null && root.right==null){
            int tmp = 0;
            for(int i=0;i<list.size();i++)
             {
                 tmp = tmp+list.get(i)*(int)Math.pow(10,list.size()-i-1);
             }
             
             sum = sum+tmp;
        }
        
        helper(root.left,list);
        helper(root.right,list);
        list.remove(list.size()-1);
    }

}