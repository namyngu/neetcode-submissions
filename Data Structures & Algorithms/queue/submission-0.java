class Deque {
    int size;
    ListNode dummyH;
    ListNode dummyT;

    public Deque() {
        size = 0;
        dummyH = new ListNode(0);
        dummyT = new ListNode(0);
        dummyH.next = dummyT;
        dummyT.prev = dummyH;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void append(int value) {
       ListNode tmp = new ListNode(value);
       tmp.prev = dummyT.prev;
       tmp.next = dummyT;

       dummyT.prev = tmp;
       tmp.prev.next = tmp;

       size++;
    }

    public void appendleft(int value) {
        ListNode tmp = new ListNode(value);
        tmp.prev = dummyH;
        tmp.next = dummyH.next;

        tmp.prev.next = tmp;
        tmp.next.prev = tmp;
        
        size++;
    }

    public int pop() {
        if (size == 0) {
            return - 1;
        }

        ListNode node = dummyT.prev;
        node.prev.next = dummyT;
        node.next.prev = node.prev;
        
        size--;
        return node.val;
    }

    public int popleft() {
        if (size == 0) {
            return - 1;
        }

        ListNode node = dummyH.next;
        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;
        return node.val;
    }

    private class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }
    }
}
