class KthLargest {
    int k;
    List<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new ArrayList<>();
        minHeap.add(0);
        for (int i = 0; i < nums.length; i++) {
            push(nums[i]);
        }
    }
    
    public int add(int val) {
        push(val);
        return minHeap.get(1);
    }

    public void push(int val) {
        minHeap.add(val);
        if (minHeap.size() <= 2) {
            return;
        }
        
        // Percolate up
        int i = minHeap.size() - 1;
        while (i > 1 && minHeap.get(i) < minHeap.get(i / 2) ) {
            int tmp = minHeap.get(i);
            minHeap.set(i, minHeap.get(i / 2));
            minHeap.set(i / 2, tmp);
            i = i / 2;
        }
        
        // Only store k integers
        if (minHeap.size() - 1 > k) {
            pop();
        }
    }

    private void pop() {
        minHeap.set(1, minHeap.get(minHeap.size() - 1));
        minHeap.remove(minHeap.size() - 1);
        

        // Percolate down
        int i = 1;
        // Only percolate down if there's a child.
        while (i * 2 <= minHeap.size() - 1) {
            int tmp = minHeap.get(i);
            int j;      // j is the descendent with the smaller value.
            if (i * 2 + 1 <= minHeap.size() - 1) {
                j = (minHeap.get(i * 2) <= minHeap.get(i * 2 + 1)) ? i * 2 : i * 2 + 1;
            }
            else {
                j = i * 2;
            }

            if (minHeap.get(i) > minHeap.get(j)) {
                minHeap.set(i, minHeap.get(j));
                minHeap.set(j, tmp);
            }
            else {
                break;
            }

            i = j;
        }
    }
}
