class Solution {
    Map<List<Integer>, List<List<Integer>>> adj;        // src -> [dest, w]
    public int swimInWater(int[][] grid) {
        // Build adjacency list
        adj = new HashMap<>();        // src -> [dest, w]
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> src = new ArrayList<>();
                src.add(i);
                src.add(j);
                adj.put(src, new ArrayList<>());
                addNeigh(src, i + 1, j, grid, n);
                addNeigh(src, i - 1, j, grid, n);
                addNeigh(src, i, j + 1, grid, n);
                addNeigh(src, i, j - 1, grid, n);
            }
        }

        // Compute shortest path.
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.get(2) - b.get(2)));    // (i, j, w)
        minHeap.add(new ArrayList<>(List.of(0, 0, grid[0][0])));
        Map<List<Integer>, Integer> shortest = new HashMap<>();
        while (!minHeap.isEmpty()) {
            List<Integer> cur = minHeap.poll();
            int i = cur.get(0), j = cur.get(1), w = cur.get(2);
            List<Integer> src = new ArrayList<>(List.of(i, j));
            if (shortest.containsKey(src)) {
                continue;
            }
            shortest.put(src, w);

            // add neighbours to minheap
            for (List<Integer> neigh : adj.get(src)) {
                int w2 = neigh.get(2);
                List<Integer> pair = new ArrayList<>(List.of(neigh.get(0), neigh.get(1)));
                // if (shortest.containsKey(pair)) {
                //     continue;
                // }
                pair.add(Math.max(w2, w));
                minHeap.add(pair);
            }
        }
        return shortest.get(List.of(n - 1, n - 1));

    }

    public void addNeigh(List<Integer> src, int i, int j, int[][] grid, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return;
        }
        int w = grid[i][j];
        List<Integer> cur = new ArrayList<>(List.of(i, j));
        if (!adj.containsKey(cur)) {
            adj.put(cur, new ArrayList<>());
        }
        List<Integer> tuple = new ArrayList<>(cur);     // (i, j, w)
        tuple.add(w);   
        adj.get(src).add(tuple);
    }
}
