class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer[]> capitalMinHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);      // [capital, index] min heap
        PriorityQueue<Integer> profitsMaxHeap = new PriorityQueue<>((a, b) -> b - a);              // max heap

        for (int i = 0; i < capital.length; i++) {
            capitalMinHeap.add(new Integer[]{capital[i], i});
        }

        while (k > 0) {
            while (!capitalMinHeap.isEmpty() && w >= capitalMinHeap.peek()[0]) {
                Integer[] c = capitalMinHeap.poll();
                profitsMaxHeap.add(profits[c[1]]);
            }

            if (!profitsMaxHeap.isEmpty()) {
                w += profitsMaxHeap.poll();
            }
            
            k--;
        }
        return w;
    }
}