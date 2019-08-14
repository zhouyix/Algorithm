import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import javafx.scene.layout.Priority;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */
class Solution {
    public class Node{
        public int value;
        public int count;
        public Node(int value,int count){
           this.value = value;
           this.count = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Node> map = new HashMap();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
          if(map.containsKey(nums[i])){
             map.get(nums[i]).count++;
          }else{
              Node n = new Node(nums[i],1);
              map.put(nums[i],n);
          }
        }

        Node[] nodes = map.values().toArray(new Node[0]);
        Arrays.sort(nodes,new Comparator<Node>() {
            @Override
            public int compare(Node n1,Node n2){
              return n2.count - n1.count;
            }
        });

        for(int i=0;i<k;i++){
            res.add(nodes[i].value);
        }

        return res;
    }
}

