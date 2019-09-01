/*
 * @lc app=leetcode id=1019 lang=java
 *
 * [1019] Next Greater Node In Linked List
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
    public int[] nextLargerNodes(ListNode head) {
        ListNode p = head;
        ArrayList<Integer> l = new ArrayList();
        while(p!=null){
            l.add(p.val);
            p=p.next;
        }

        int[] arr = new int[l.size()];  
        int i=0;
        for(int v:l){
            arr[i++]=v;
        }

        //index , next larger 
        Stack<Integer> s = new Stack();
        HashMap<Integer,Integer> res = new HashMap();
        i=0;
        while(i<arr.length){
            if(s.isEmpty()){
                s.push(i);
            }else{
                while(!s.isEmpty() && arr[i] > arr[s.peek()]){
                    res.put(s.peek(),arr[i]);
                    s.pop();
                }

                s.push(i);
            }

            i++;
        }

        while(!s.isEmpty()){
            res.put(s.peek(),0);
            s.pop();
        }

        int[] t = new int[arr.length];
        for(Map.Entry<Integer,Integer> en : res.entrySet()){
            t[en.getKey()] = en.getValue();
        }

        return t;
    }
}

