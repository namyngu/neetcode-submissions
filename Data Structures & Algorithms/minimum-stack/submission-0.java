class MinStack {
    private int min;
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty()) {

            minStack.push(val);
        }
        else if (val < minStack.peek()) {
            minStack.add(val);
        }
        else {
            minStack.add(minStack.peek());
        }

        stack.push(val);
    }

    // removes the element on the top of the stack.
    public void pop() {
        stack.pop();
        minStack.pop();
    }

    // gets the top element of the stack.
    public int top() {
        return stack.peek();
    }


    public int getMin() {
        return minStack.peek();
    }
}
