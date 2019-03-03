/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode p = headA,q = headB;
        int len1 =0,len2=0;
        while(p!=null){
            p=p.next;
            len1++;
        }
        while(q!=null){
            q=q.next;
            len2++;
        }
        p = len1 > len2 ? headA:headB;
        q = len1 <= len2 ? headA:headB;
        
        int diff = Math.abs(len1-len2);
        while(diff>0){
            diff--;
            p = p.next;
        }
        
        while(p!=null && q!=null && p!=q){
            p=p.next;
            q=q.next;
        }
        if(p!=null && q!=null)
           return p;
        else
          return null;
    }
}