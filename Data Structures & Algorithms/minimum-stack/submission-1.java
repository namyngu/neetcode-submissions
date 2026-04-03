class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> minVal;  // tracks the minimum value at each "level"

    public MinStack() {
        minStack = new Stack<>();
        minVal = new Stack<>();
    }
    
    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
            minVal.push(val);
        }
        else {
            minStack.push(val);
            minVal.push(Math.min(minVal.peek(), val));
        }
        
    }
    
    public void pop() {
        if (!minStack.isEmpty()) {
            minStack.pop();
            minVal.pop();
        }
        
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return minVal.peek();
    }
}
