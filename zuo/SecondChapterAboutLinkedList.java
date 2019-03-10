package zuo;

import common.LinkNode;

import java.util.LinkedList;

public class SecondChapterAboutLinkedList {

    //use fast and slow points to find the mid
    //reverse the first half part
    public static boolean isParlindrome(LinkNode head){
        LinkNode fast = head;
        LinkNode slow = head;

        while(fast.next!=null && fast.next.next != null){
            fast = fast.next.next;  // stop at end if len is odd or end-1
            slow = slow.next; // stop at the mid or mid -1

        }

        //reverse right part ,from a->b->c->b->a to a->b->c<-b<-a
        LinkNode start = slow.next;
        LinkNode tail = slow;
        while(start!=null){
            LinkNode next = start.next;
            start.next = tail;
            tail = start;
            start = next;
        }

        //begin to compare
        LinkNode leftStart = head;
        LinkNode rightStart = tail;
        LinkNode recoverNode = tail;
        boolean flag = true;
        while(leftStart != tail){
            if(leftStart.value!= rightStart.value){
                flag = false;
                break;
            }

            leftStart = leftStart.next;
            rightStart = rightStart.next;
        }

        //recover from recover node to slow
        tail = null;
        while(recoverNode != slow){
            LinkNode next = recoverNode.next;
            recoverNode.next = tail;
            tail = recoverNode;
            recoverNode = next;
        }

        slow.next = tail;

        return flag;
    }

}
