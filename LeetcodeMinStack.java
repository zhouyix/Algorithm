public class MinStack {
    Stack<Integer> backMin ;
    Stack<Integer> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        backMin = new Stack<Integer>();
        stack = new Stack<Integer>();
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(backMin.isEmpty() || backMin.peek() >= x ){
            backMin.push(x);
        }
        
    }
    
    public void pop() {
        int top = stack.pop();
        if(top == backMin.peek()){
            backMin.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return backMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */