class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        // update node to most recently used.
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;

        return node.val;
    }
    
    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            Node node = new Node(key, value);
            cache.put(key, node);

            updateRecentlyUsed(node);

            if (cache.size() > capacity) {
                removeLeastUsed();
            }
        }
        else {
            Node node = cache.get(key);
            node.val = value;
            
             // update node to most recently used.
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = head;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
        }
    }

    public void updateRecentlyUsed(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    public void removeLeastUsed() {
        Node node = tail.prev;
        cache.remove(node.key);

        node.prev.next = tail;
        tail.prev = node.prev;
    }
}

class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(){}
        public Node(int val) {
            this.val = val;
        }
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
