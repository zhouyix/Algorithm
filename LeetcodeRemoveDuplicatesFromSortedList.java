public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
          return head; 
        ListNode p=head;
        ListNode r=head;
        
        while(r!=null)
        {
          while(p.next!=null && p.val==p.next.val)
          {
            p=p.next;
          }
          r.next=p.next;
          r=p.next;
          p=p.next;
        }
        
        return head;
        
    }
}