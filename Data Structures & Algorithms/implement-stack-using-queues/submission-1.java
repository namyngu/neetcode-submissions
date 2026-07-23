class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    // O(n) time complexity.
    public int pop() {
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            int num = q.poll();
            q.offer(num);
        }

        return q.poll();
    }
    
    // O(n) time complexity.
    public int top() {
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            int num = q.poll();
            q.offer(num);
        }

        int lastNum = q.poll();
        q.offer(lastNum);
        return lastNum;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */