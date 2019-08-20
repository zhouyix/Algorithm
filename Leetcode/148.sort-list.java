/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public ListNode sortList(ListNode head) {
    //     if(head==null){
    //         return  head;
    //     }
    //     ListNode dummy=new ListNode(Integer.MIN_VALUE);
    //     dummy.next=head;
        
    //     ListNode p=head.next;
    //     head.next=null;
    //     sort(dummy,p);
    //     return dummy.next;
    // }

    // public void sort(ListNode dummy,ListNode p){
    //     if(p==null)
    //     return;

    //     ListNode head=dummy;
    //     ListNode q=p.next;
    //     while(head.next!=null&&head.next.val<p.val){
    //         head=head.next;
    //     }

    //     p.next=head.next;
    //     head.next=p;

    //     sort(dummy,q);
    // }

    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode prev=null,slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
           prev=slow;
           slow=slow.next;
           fast=fast.next.next;
        }

        prev.next=null;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);

        return merge(l1,l2);
    }


    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;
        
        while (l1 != null && l2 != null) {
          if (l1.val < l2.val) {
            p.next = l1;
            l1 = l1.next;
          } else {
            p.next = l2;
            l2 = l2.next;
          }
          p = p.next;
        }
        
        if (l1 != null)
          p.next = l1;
        
        if (l2 != null)
          p.next = l2;
        
        return l.next;
      }
}

