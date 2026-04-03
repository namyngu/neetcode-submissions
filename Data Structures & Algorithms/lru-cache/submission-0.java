
public class LRUCache {
    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {}

        public Node(int value) {
            this.value = value;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int CAPACITY;
    private int size = 0;
    Map<Integer,Node> lruMap;
    Node head = new Node();
    Node tail = new Node();

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        lruMap = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = lruMap.getOrDefault(key, new Node(-1));

        if (node.value != -1) {
            // move node to tail.
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
        }
        return node.value;
    }

    public void put(int key, int value) {
        if (lruMap.containsKey(key)) {
            // update value
            Node node = lruMap.get(key);
            node.value = value;

            // move node to tail.
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
        }
        else if (size < CAPACITY) {
            // key doesn't exist and size < capacity
            Node node = new Node(key, value);
            // insert node at tail
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            lruMap.put(key, node);

            size++;
        }
        else {
            // key doesn't exist and size exceeds capacity.
            // Evict LRU - remove from hashmap then remove from linked list.
            lruMap.remove(head.next.key);       // this is why we need the node to store the key.
            head.next.next.prev = head;
            head.next = head.next.next;

            // Create new node.
            Node node = new Node(key, value);
            lruMap.put(key, node);

            // insert node at tail
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            lruMap.put(key, node);
        }
    }
}
