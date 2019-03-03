import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(getNum(new int[]{4,2,1,3,0},2));
    }

    //use a help stack to sort a stack
    //help stack saves num desc
    public static void sortStackByHelpStack(Stack<Integer> stack) {
        Stack<Integer> helper = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int top = stack.pop();
            while (!helper.isEmpty() && top > helper.peek()) {
                stack.push(helper.pop());
            }

            helper.push(top);
        }

        while (!helper.empty()) {
            stack.push(helper.pop());
        }
    }

    //reverse stack using recursive fun
    public static void reverseStack(Stack<Integer> s) {
        if (s.size() <= 1) {
            return;
        }

        int last = getAndRemoveLastElem(s);
        reverseStack(s);
        s.push(last);
    }

    public static int getAndRemoveLastElem(Stack<Integer> s) {
        int top = s.pop();
        if (s.size() == 0) {
            return top;
        } else {
            int last = getAndRemoveLastElem(s);
            s.push(top);
            return last;
        }
    }

    //use two ends queue,save the values desc
    //if arr[i] < arr.last ,last add(may be the result for next window),
    //while arr[i] >= arr.last, poll last until last can be added
    //check the first is out of date then poll first as result
    //the maximum capacity of queue is size + 1
    public static void getMaxValueInWindow(int[] arr, int size) {
        if (arr.length < size) {
            return;
        }

        int[] res = new int[arr.length - size + 1];
        int k = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]) {
                q.pollLast();
            }

            q.addLast(i);
            if (q.peekFirst() == i - size) {
                q.pollFirst();
            }

            if (i >= size) {
                res[k++] = arr[q.peekFirst()];
            }
        }
    }


    //first the min(first bigger value from left,first bigger value from right)
    //if both bigger values are null means ,arr[i] is the tree head
    public static Node getMaxTree(int[] arr) {

        HashMap<Node, Node> lmap = new HashMap<>();
        HashMap<Node, Node> rmap = new HashMap<>();

        Node[] res = new Node[arr.length];
        //save the first bigger value from left side
        Stack<Node> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            res[i] = node;
            //keep stack desc fro top to down
            while (!s.empty() && s.peek().value < arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                lmap.put(node, null);
            } else {
                lmap.put(node, s.peek());
            }

            s.push(node);
        }

        //in case arr has desc fragment
        while (!s.empty()) {
            Node top = s.pop();
            if (s.empty()) {
                lmap.put(top, null);
            } else {
                lmap.put(top, s.peek());
            }
        }

        //save the first bigger value from right side
        for (int i = arr.length - 1; i > -1; i--) {
            Node node = new Node(arr[i]);

            //keep stack desc fro top to down
            while (!s.empty() && s.peek().value < arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                rmap.put(node, null);
            } else {
                rmap.put(node, s.peek());
            }

            s.push(node);
        }

        while (!s.empty()) {
            Node top = s.pop();
            if (s.empty()) {
                rmap.put(top, null);
            } else {
                rmap.put(top, s.peek());
            }
        }
        Node head = null;
        for(int i=0;i<res.length;i++){
            Node left = lmap.get(res[i]);
            Node right = rmap.get(res[i]);
            if(left == null && right == null){
                head = res[i];
            }else if(left == null){
                if(right.left == null){
                    right.left = res[i];
                }else{
                    right.right = res[i];
                }
            }else if(right == null){
                if(left.left == null){
                    left.left = res[i];
                }else{
                    left.right = res[i];
                }

            }else{
                Node parent = left.value > right.value ? right : left;
                if(parent.left==null){
                    parent.left = res[i];
                }else{
                    parent.right = res[i];
                }
            }

        }
        return head;
    }


    //get the count of subarr in which max - min <= k
    public static int getNum(int[] arr, int k){
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i=0,j=0,res=0;
        while(i<arr.length){
            while(j<arr.length){
                //save the min during j expands to right
                while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j])
                    qmin.pollLast();
                qmin.addLast(j);

                //save the max during j expands to right
                while(!qmax.isEmpty() && arr[qmax.peekLast()] < arr[j])
                    qmax.pollLast();
                qmax.addLast(j);

                //stop j expand then i expands to right
                if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > k){
                    break;
                }

                j++;
            }

            //remove out of date value
            if(qmin.peekFirst() == i)
                qmin.pollFirst();
            if(qmax.peekFirst() == i)
                qmax.pollFirst();

            res = res + j-i;
            i++;
        }

        return  res;
    }


}
