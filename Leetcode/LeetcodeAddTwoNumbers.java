public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1,q = l2;
        ListNode head = new ListNode(-1),last = head;
        int add = 0;
        while(p!=null && q!=null)
        {
            ListNode tmp = new ListNode((p.val+q.val+add)%10);
            add =(p.val+q.val+add)/10;
            last.next = tmp;
            last = last.next;
            p=p.next;
            q=q.next;
        }
        
        while(p!=null)
        {
            ListNode tmp = new ListNode((p.val+add)%10);
            add =(p.val+add)/10;
            last.next = tmp;
            last = last.next;
            p=p.next;
        }
        
       while(q!=null)
        {
            ListNode tmp =new ListNode((q.val+add)%10);
            add =(q.val+add)/10;
            last.next = tmp;
            last = last.next;
            q=q.next;
        }
        
        if(add!=0)
          {
             ListNode tmp = new ListNode(add);
             last.next = tmp;
             last = last.next;
          }
          
          return head.next;
    }
}