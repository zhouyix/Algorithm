/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
     ListNode pre=new ListNode(-1),p=head,begin=new ListNode(-1),now=begin,smallBegin=head;
        pre.next=p;
        boolean flag=false,flag1=false;
        while(p!=null)
        {
        	while(p !=null && p.val < x)
        	{

        		pre=p;
        		p=p.next;
        		if(!flag1)
        		{
        		    flag1=true;
        			smallBegin=pre;
        		}
        	}
            //第一次找到big的head
            if(p!=null){
            	pre.next=p.next;
            	p.next=null;
            	if(!flag){
            		flag=true;
            	}
                now.next=p;
                now=now.next;
                p=pre.next;
            }	
        }
        
        if(flag)
        {
        	pre.next=begin.next;
        	begin.next=null;
        	
        }
        
        return smallBegin;
    }
}