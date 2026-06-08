class Solution {
    public int orangesRotting(int[][] grid) {
        List<int[]> start = new ArrayList<>();
        Set<String> fresh = new HashSet<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 2) {
                    start.add(new int[]{r, c});
                }
                if (grid[r][c] == 1) {
                    fresh.add(r + "," + c);
                }
            }
        }
        if (fresh.size() == 0) {
            return 0;
        }

        if (start.size() == 0) {
            return -1;
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int min = -1;
        for (int[] pos : start) {
            q.addLast(pos);
        }

        // do bfs from all starting positions.
        while (!q.isEmpty()) {
            min++;
            int qLength = q.size();
            for (int i = 0; i < qLength; i++) {
                int[] pos = q.removeFirst();
                int r = pos[0];
                int c = pos[1];
                fresh.remove(r + "," + c);
                

                // add valid neighbours to queue.
                int[][] neighbours = new int[][]{
                    {r - 1, c}, {r + 1, c}, {r, c - 1}, {r, c + 1}
                };
                for (int j = 0; j < 4; j++) {
                    int newR = neighbours[j][0];
                    int newC = neighbours[j][1];

                    if (Math.min(newR, newC) < 0 || newR >= grid.length || newC >= grid[newR].length ||
                        grid[newR][newC] != 1) {
                        continue;
                    }

                    q.addLast(new int[]{newR, newC});
                    grid[newR][newC] = 2;        // this can replace a visited hashmap.
                }
            }

            if (fresh.isEmpty()) {
                return min;
            }
        }
        return  -1;
    }
}
