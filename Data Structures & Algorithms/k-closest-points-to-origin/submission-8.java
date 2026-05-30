class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> 
        Math.abs(a[0]*a[0] + a[1]*a[1]) - Math.abs(b[0]*b[0] + b[1]*b[1]));

        for (int i = 0; i < points.length; i++) {
            minHeap.add(points[i]);
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }

        return res;
    }
}
