class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        if (ROWS == 1) {
            return 1;
        }

        Deque<int[]> q = new ArrayDeque<>();
        int length = 0;
        q.addLast(new int[]{0, 0});
        visited.add(0 + "," + 0);

        // bfs
        while (!q.isEmpty()) {
            length++;
            int qLength = q.size();
            for (int i = 0; i < qLength; i++) {
                int[] coords = q.removeFirst();
                int r = coords[0];
                int c = coords[1];
                visited.add(r + "," + c);

                int[][] neighbours = {
                    {r - 1, c - 1},         // top left
                    {r - 1, c},             // top middle
                    {r - 1, c + 1},         // top right
                    {r, c - 1},             // middle left
                    {r, c + 1},             // middle right
                    {r + 1, c - 1},         // bottom left
                    {r + 1, c},             // bottom middle
                    {r + 1, c + 1}          // bottom right
                };
                // add valid neighbours to queue
                for (int j = 0; j < 8; j++) {
                    int newR = neighbours[j][0];
                    int newC = neighbours[j][1];

                    if (newR == ROWS - 1 && newC == COLS - 1) {
                        return length + 1;
                    }
                    if (Math.min(newR, newC) < 0 || newR >= ROWS || newC >= COLS ||
                        grid[newR][newC] == 1 || visited.contains(newR + "," + newC)) {
                        continue;
                    }

                    q.addLast(new int[]{newR, newC});
                    visited.add(newR + "," + newC);
                }
            }
        }

        return -1;
    }
}