public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
          return head; 
        ListNode pre=new ListNode(-1);
        pre.next=head;
        head=pre;
        ListNode p=pre.next;
        ListNode r=pre.next;
        boolean flag=false;
        while(r!=null)
        {
          while(p.next!=null && p.val==p.next.val)
          {
            flag=true;
            p=p.next;
          }
          if(flag){
          pre.next=p.next; 
          p=p.next;
          r=p;
          }
          else
          {
              pre=r;
              p=p.next;
              r=r.next;
              
          }
         flag=false;
         
        }
        
        return head.next;
    }
}