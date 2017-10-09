/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
     if(node==null)
    	   return null;
       
       Queue<UndirectedGraphNode> queue = new  LinkedList<UndirectedGraphNode>();
       HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
       
       UndirectedGraphNode begin = new UndirectedGraphNode(node.label);
       map.put(node, begin);
       queue.offer(node);
       
       while(!queue.isEmpty()){
    	   UndirectedGraphNode tmp = queue.poll();
    	   for(int i =0 ; i < tmp.neighbors.size() ;i++)
    	   {
    		   if(!map.containsKey(tmp.neighbors.get(i))){
    			   begin = new UndirectedGraphNode(tmp.neighbors.get(i).label);
    			   map.put(tmp.neighbors.get(i), begin);
    			   queue.offer(tmp.neighbors.get(i));
    		   }
    		   map.get(tmp).neighbors.add(map.get(tmp.neighbors.get(i)));
    	   }
       
      }
	return map.get(node);
    }
}