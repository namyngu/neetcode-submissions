// Time Taken: 40:32
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // build adjacency list.
        Map<Integer, List<int[]>> adjList = new HashMap<>();        // src -> [dest, weight]
        for (int i = 0; i < times.length; i++) {
            int src = times[i][0], dest = times[i][1], w = times[i][2];

            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.putIfAbsent(dest, new ArrayList<>());
            adjList.get(src).add(new int[]{dest, w});
        }

        // Compute shortest path
        Map<Integer, Integer> shortest = new HashMap<>();       // node -> shortest path
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);      // [cost, dest]
        minHeap.add(new int[]{0, k});
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int w = cur[0], n1 = cur[1];
            if (shortest.containsKey(n1)) {
                continue;
            }
            shortest.put(n1, w);

            for (int[] neigh : adjList.get(n1)) {
                int n2 = neigh[0], w2 = neigh[1];
                if (shortest.containsKey(n2)) {
                    continue;
                }
                minHeap.add(new int[]{w2 + w, n2});
            }
        }
        // find result
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (!shortest.containsKey(i)) {
                return -1;
            }
            res = Math.max(res, shortest.get(i));
        }
        return res;
    }
}
