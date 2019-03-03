/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
     public TreeNode sortedListToBST(ListNode head) {

        if(head == null)
        	return null;
        ListNode p = head;
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        while(p!=null){
        	list.add(p);
        	p=p.next;
        }
        return helper(list,0,list.size()-1);
    }

    public TreeNode helper(ArrayList<ListNode> list,int l,int r){
            if(l <= r){
              int mid = (l+r)/2;
              TreeNode root = new TreeNode(list.get(mid).val);
              root.left = helper(list,l,mid-1);
              root.right = helper(list,mid+1,r);
              return root;
            }
            return null;
        }
}