class MyCalendar {
    Node root;

    public MyCalendar() {
        
    }
    
    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new Node(startTime, endTime);
            return true;
        }
        Node curr = root;
        return bookHelper(curr, startTime, endTime);

    }

    public boolean bookHelper(Node curr, int startTime, int endTime) {
        if (startTime >= curr.end) {
            if (curr.right == null) {
                curr.right = new Node(startTime, endTime);
                return true;
            }
            return bookHelper(curr.right, startTime, endTime);
        }
        else if (endTime <= curr.start) {
            if (curr.left == null) {
                curr.left = new Node(startTime, endTime);
                return true;
            }
            return bookHelper(curr.left, startTime, endTime);
        }
        return false;
    }
}

class Node {
    int start;
    int end;
    Node left;
    Node right;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */