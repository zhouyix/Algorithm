/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
           return null;
           
        RandomListNode now = head;
        while(now!=null){
            RandomListNode newNode = new RandomListNode(now.label);
            newNode.next = now.next;
            now.next= newNode;
            
            now = now.next.next;
        }
        
        now = head;
        while(now!=null){
            if(now.random!=null)
              now.next.random = now.random.next;
             
            now = now.next.next;
        }
        
       RandomListNode p = head.next;
       RandomListNode newHead = head.next;
       
       now = head;
       while(now!=null){
           now.next = now.next.next;
           if(p.next!=null)
             p.next = p.next.next;
           else
             p.next=null;
           
           now = now.next;
           p = p.next;
       }
       
       return newHead;
       
    }
}