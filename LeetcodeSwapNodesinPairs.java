public class Solution {
    public ListNode swapPairs(ListNode head) {
         if(head==null || head.next==null)
			 return head;
	        ListNode pre=new ListNode(0),after=null,p=head,q=head.next,h=q;
	        pre.next=p;
	        while(q!=null)
	        {
	        	if(q!=null)
	        		after=q.next;
	        	p.next=after;
	        	pre.next=q;
	        	q.next=p;
	    
	        	pre=p;	
	        	p=after;
	        	if(p!=null)
	        		q=p.next;
	        	else
	        		q=null;
	        }
	        
	        return h;
    }
	
	
	 public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}