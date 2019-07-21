/*
 * @lc app=leetcode id=622 lang=java
 *
 * [622] Design Circular Queue
 */
class MyCircularQueue {
    int front;
    int end;
    int[] arr;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k+1];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()){
            arr[end] = value;
            end = (end+1)%arr.length;
            return true;
        }

        return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
       if(!isEmpty()){
           arr[front] = -1;
           front = (front+1)%arr.length;
           return true;
       }

       return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return  isEmpty() ? -1 : arr[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : arr[(end+arr.length-1)%arr.length];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == end;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (end+1)%arr.length == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

