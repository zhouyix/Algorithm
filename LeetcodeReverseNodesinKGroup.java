public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
          ListNode nh=head;
        int i=0;
        while(i<k){
            if(nh!=null)
                nh=nh.next;
            else
                return head;
            i++;
        }

        ListNode p=head.next;
        ListNode pre=head;
        while(p!=nh){
            ListNode after=p.next;
            p.next=pre;
            pre=p;
            p=after;
        }

        head.next=reverseKGroup(nh,k);
        return pre;
    }
}