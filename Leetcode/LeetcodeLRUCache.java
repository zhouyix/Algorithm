public class LRUCache {
    public class Node {
    int key,value;
    Node next;
    Node pre;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.pre = null;
    }
   }

   int capacity ;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
   
   
    public LRUCache(int capacity) {
       this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    public void set(int key, int value) {
       if(map.containsKey(key)){
           Node  node = map.get(key);
           node.value = value;
           deleteNode(node);
           addToHead(node);
       }else{
           Node node = new Node(key,value);
           map.put(key,node);
           if(map.size() > capacity){
               map.remove(tail.pre.key);
               deleteNode(tail.pre);
           }
           addToHead(node);
       }

    }

    public void deleteNode(Node node){
          node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    public void addToHead(Node node){
        node.next = head.next;
        node.pre = head;

        node.next.pre =  node;
        head.next = node;

    }

}