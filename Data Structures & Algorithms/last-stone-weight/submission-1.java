class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        int x;
        int y;
        while (true) {
            if (maxHeap.size() < 2) {
                return maxHeap.poll();
            }
            x = maxHeap.poll();
            y = maxHeap.poll();

            int tmp = Math.abs(x - y);
            maxHeap.add(tmp);
        }  
    }
}
