// No adjacency list required
class Solution {
    int res;
    public int swimInWater(int[][] grid) {
        res = 0;
        int n = grid.length;
        // Compute shortest path
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> a.get(2) - b.get(2));  // (i, j, w)
        minHeap.add(new ArrayList<>(List.of(0, 0, grid[0][0])));
        Set<List<Integer>> visited = new HashSet<>();       // List compares by content because its equals() and hashCode() have already been overriden.

        List<int[]> directions = new ArrayList<>(
            List.of(new int[]{1,0}, new int[]{-1,0}, new int[]{0,1}, new int[]{0,-1})
            );    // down, up, right, left

        while (!minHeap.isEmpty()) {
            List<Integer> tuple = minHeap.poll();
            int i = tuple.get(0), j = tuple.get(1), w = tuple.get(2);
            List<Integer> src = new ArrayList<>(List.of(i, j));
            if (visited.contains(src)) {
                continue;
            }
            res = Math.max(res, w);

            if (i == n - 1 && j == n - 1) {
                return res;
            }
            visited.add(src);

            // add adjacent paths to minheap
            for (int[] dir : directions) {
                int iNew = i + dir[0];
                int jNew = j + dir[1];
                List<Integer> newPath = new ArrayList<>(List.of(iNew, jNew));
                if (iNew < 0 || iNew >= n || jNew < 0 || jNew >= n || visited.contains(newPath)) {
                    // invalid path.
                    continue;
                }
                newPath.add(Math.max(w, grid[iNew][jNew]));
                minHeap.add(newPath);
            }
        }
        return -1;
    }
}
