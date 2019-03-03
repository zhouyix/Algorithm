/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
          return head;
        int i=1;
        ListNode p=head,q=head;
        ListNode pre=new ListNode(-1);
        pre.next=p;
        while( i !=m && p!=null)
        {
            pre=p;
            p=p.next;
            i++;
        }
        q=p;
        while(i!=n && q!=null)
        {
            q=q.next;
            i++;
        }
        
       
          pre.next= reverse(q.next,p,q.next);
          
          if(m==1)
          return pre.next;
          else
          return head;
         
        
    }
    
     public ListNode reverse(ListNode begin,ListNode head,ListNode end)
    {
       
          if(head==end)
            return begin;
           
          ListNode p=head.next;
          head.next=begin;
          begin=head;
          
         return reverse(begin,p,end);
    }
}