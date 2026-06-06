// We're using chaining instead of open addressing, as it's easier to write the remove method.
class HashTable {
    int capacity;
    int size;
    Node[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        table = new Node[capacity];
    }

    public void insert(int key, int value) {
        int index = hashFunction(key);
        if (table[index] == null) {
            table[index] = new Node(key, value);
            size++;
        }
        else {
            Node node = table[index];
            Node prev = table[index];

            while (true) {
                if (node == null) {
                    prev.next = new Node(key, value);
                    size++;
                    break;
                }
                if (node.key == key) {
                    node.val = value;
                    break;
                }
                prev = node;
                node = node.next;
            }
        }

        if (capacity / 2 <= size) {
            resize();
        }
    }

    public int get(int key) {
        int index = hashFunction(key);
        Node node = table[index];
        while (true) {
            if (node == null) {
                return -1;
            }

            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
    }

    public boolean remove(int key) {
        int index = hashFunction(key);
        if (table[index] == null) {
            return false;
        }
        if (table[index].key == key) {
            table[index] = null;
            size--;
            return true;
        }

        Node node = table[index];
        Node prev = node;
        while (true) {
            if (node == null) {
                return false;
            }
            if (node.key == key) {
                prev.next = null;
                size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resize() {
        Node[] oldTable = table;
        table = new Node[capacity * 2];
        capacity = capacity * 2;
        size = 0;

        for (Node node : oldTable) {
            while (node != null) {
                insert(node.key, node.val);
                node = node.next;
            }
        }
    }

    int hashFunction(int key) {
        return key % capacity;
    }

    class Node {
        int val;
        int key;
        Node next;

        public Node(){}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
