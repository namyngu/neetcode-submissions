class Solution {
    Map<Integer, List<double[]>> adj;  // src -> [p, dest]
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        adj = new HashMap<>();

        // Build Adjacency list
        for (int i = 0; i < n; i++) {
            // IMPORTANT: Initialize the nodes before building adjacency.
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {        
            int src = edges[i][0];
            int dest = edges[i][1];
            double p = succProb[i];
            adj.get(src).add(new double[]{p, dest});
            adj.get(dest).add(new double[]{p, src});
        }

        // Compute path
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));   // [p, node]
        maxHeap.offer(new double[]{1, start_node});
        Set<Double> visited = new HashSet<>();

        while (!maxHeap.isEmpty()) {
            double[] pair = maxHeap.poll();
            double p = pair[0], cur = pair[1];
            if (cur == end_node) {
                return p;
            }
            if (visited.contains(cur)) {
                continue;
            }

            for (double[] newPath : adj.get((int) cur)) {
                double p2 = newPath[0] * p;
                double node2 = newPath[1];
                maxHeap.offer(new double[] {p2, node2});
            }
            visited.add(cur);
        }

        return 0;
    }
}