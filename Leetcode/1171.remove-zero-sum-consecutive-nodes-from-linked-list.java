/*
 * @lc app=leetcode id=1171 lang=java
 *
 * [1171] Remove Zero Sum Consecutive Nodes from Linked List
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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p=head;
        ListNode prev = dummy;
        int sum=0;
        HashMap<Integer,ListNode> map = new HashMap();
        map.put(0,prev);

        while(p!=null){
            sum+= p.val;
           if(map.containsKey(sum)){
                ListNode start = map.get(sum);
                start.next = p.next;
            }else{
                map.put(sum,p);
            }

           // prev = p;  
            p= p.next;
        }

        return dummy.next;
        
    }
}

