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
    public TreeNode AddOneRow(TreeNode root, int v, int d) {
        if(d == 1)
        {
            var newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        
        var list = new List<TreeNode>();
        int h = 0;
        list.Add(root);
        int count = list.Count;
        while(true)
        {
            h++;
            if(h!=d-1)
            {
                int tmp =0;
                while(tmp!=count)
                {
                     var remove = list[0];
                     list.RemoveAt(0);
                     tmp++;
                   if(remove.left!=null) list.Add(remove.left);
                   if(remove.right!=null) list.Add(remove.right);
                    
                }
                
                count = list.Count;
            }
            else
            {
                int tmp =0;
                while(tmp!=count)
                {
                  var newLeft = new TreeNode(v);
                  var newRight = new TreeNode(v);
                    var remove = list[0];
                        list.RemoveAt(0);
                    newLeft.left = remove.left;
                    remove.left = newLeft;
                    newRight.right = remove.right;
                    remove.right = newRight;
                    tmp++;
                }
                
                return root;
              
            }
        }
    }
}