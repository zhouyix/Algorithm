/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
          return head;
          
        ListNode pre = new ListNode(head.val-1);
        pre.next = head;
        
        ListNode p = pre;
        while(p!=null){
            if(p.next==null)
              break;
            while(p.next!=null && p.val<p.next.val){
                p=p.next;
            }
            
            if(p.next!=null){
            ListNode q = p.next;
            p.next = q.next;
            ListNode find = pre.next;
            ListNode findPre = pre;
            while(find!=p && find.val <= q.val){
                find=find.next;
                findPre=findPre.next;
            }
            
          if(q!=null){
            q.next = find;
            findPre.next = q;
          }
          
         

            }
        }
        return pre.next;
        
    }
}