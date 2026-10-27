class MinHeap {
    List<Integer> minHeap;

    public MinHeap() {
        minHeap = new ArrayList<>();
        minHeap.add(-1);
    }

    public void push(int val) {
        minHeap.add(val);
        percolateUp(minHeap.size() - 1);
    }

    public Integer pop() {
        if (minHeap.size() < 2) {
            return -1;
        }

        int first = minHeap.get(1);
        int last = minHeap.get(minHeap.size() - 1);
        
        minHeap.set(1, last);
        minHeap.remove(minHeap.size() - 1);
        percolateDown(1);
        return first;
    }

    public Integer top() {
        if (minHeap.size() >= 2) {
            return minHeap.get(1);
        }
        return -1;
    }

    public void heapify(List<Integer> nums) {
        if (nums.size() == 0) {
            return;
        }
        nums.add(nums.get(0));
        minHeap = new ArrayList<>(nums);
        int index = (minHeap.size() - 1) / 2;
        while (index >= 1) {
            percolateDown(index);
            index--;
        }
    }

    private void percolateUp(int i) {
        while (i > 1) {
            int child = minHeap.get(i);
            int parent = minHeap.get(i / 2);

            if (child >= parent) {
                break;
            }

            minHeap.set(i, parent);
            minHeap.set(i / 2, child);
            i = i / 2;
        }
    }

    private void percolateDown(int i) {
        if (i * 2 >= minHeap.size()) {
            return;
        }

        int parent = minHeap.get(i);
        if (i * 2 + 1 > minHeap.size() - 1) {
            // Only left child
            int leftChild = minHeap.get(i * 2);
            if (parent <= leftChild) {
                return;
            }
            minHeap.set(i, leftChild);
            minHeap.set(i * 2, parent);
            percolateDown(i * 2);
        }
        else {
            // Both children exists
            int leftChild = minHeap.get(i * 2);
            int rightChild = minHeap.get(i * 2 + 1);

            if (leftChild <= rightChild && leftChild < parent) {
                // swap left
                minHeap.set(i, leftChild);
                minHeap.set(i * 2, parent);
                percolateDown(i * 2);
            }
            else if (rightChild <= leftChild && rightChild < parent) {
                // swap right
                minHeap.set(i, rightChild);
                minHeap.set(i * 2 + 1, parent);
                percolateDown(i * 2 + 1);
            }
        }
    }
}
