class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) { 
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }

        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        while (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
