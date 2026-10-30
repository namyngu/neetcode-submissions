class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer[]> capitalMaxHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);      // [capital, index] min heap
        PriorityQueue<Integer> profitsMinHeap = new PriorityQueue<>((a, b) -> b - a);               // max heap

        for (int i = 0; i < capital.length; i++) {
            capitalMaxHeap.add(new Integer[]{capital[i], i});
        }

        while (k > 0) {
            while (!capitalMaxHeap.isEmpty() && w >= capitalMaxHeap.peek()[0]) {
                Integer[] c = capitalMaxHeap.poll();
                profitsMinHeap.add(profits[c[1]]);
            }

            if (!profitsMinHeap.isEmpty()) {
                w += profitsMinHeap.poll();
            }
            
            k--;
        }
        return w;
    }
}