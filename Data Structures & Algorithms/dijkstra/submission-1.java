class Solution {
    Map<Integer, Integer> res;     // Node -> Distance
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            res.put(i, -1);
        }
        Map<Integer, List<int[]>> neighbours = new HashMap<>();     //adj list | Node -> List of neighbor nodes [node, weight]

        // Build adj list.
        for (List<Integer> edge : edges) {
            int start = edge.get(0);
            int end = edge.get(1);
            int w = edge.get(2);
            neighbours.putIfAbsent(start, new ArrayList<>());
            neighbours.putIfAbsent(end, new ArrayList<>());
            neighbours.get(start).add(new int[]{end, w});        // append neighbour to src
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));    // [cost, node]
        minHeap.add(new int[]{0, src});

        while (!minHeap.isEmpty()) {
            int[] tuple = minHeap.poll();
            int w1 = tuple[0];
            int n1 = tuple[1];
            if (res.get(n1) == -1) {
                res.put(n1, w1);
            }
            // add n1 neighbours to min heap
            for (int[] neigh : neighbours.get(n1)) {
                int n2 = neigh[0];
                int w2 = neigh[1];
                // avoid revisiting nodes again (a loop)
                if (res.get(n2) != -1) {
                    continue;
                }
                minHeap.add(new int[]{w1 + w2, n2});
            }
        }
        return res;
    }  
}
