// Intuition: We have two heaps, a min heap and a max heap.
// The max heap stores the smaller half of values and the min heap stores the larger half of values.
// That way we can always find the median by checking which heaps are bigger or if both are same size then the median is the average root value of the two heaps.
// Then it just becomes handling edge cases. 
// A trick to handling edge case is when adding numbers, arbitrarily add to a heap then compare heap sizes and root values.

class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    }
    
    public void addNum(int num) {
        maxHeap.add(num);       // arbitrarily add to maxHeap.
        if (!minHeap.isEmpty()) {
            if (maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }
        }
        
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
        else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.isEmpty()) {
            return maxHeap.peek();
        }
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
