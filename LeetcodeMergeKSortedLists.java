public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0), cur = dummy;
		if (lists == null || lists.length < 1) {
			return null;
		}
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,
				new Comparator<ListNode>(){
					@Override
					public int compare(ListNode arg0, ListNode arg1) {
						// TODO Auto-generated method stub
						return arg0.val-arg1.val;
					}
			
		});
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				pq.add(lists[i]);
		}
		
		while(pq.size()>0){
			ListNode top=pq.poll();
			cur.next=top;
			if(top.next!=null){
				pq.add(top.next);
			}
			cur=top;
		}
		
		return dummy.next;
    }
}