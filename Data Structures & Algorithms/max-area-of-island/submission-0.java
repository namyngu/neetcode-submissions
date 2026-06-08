class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        Set<String> visited = new HashSet<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 0 || visited.contains(r + "," + c)) {
                    continue;
                }

                int area = dfs(grid, r, c, visited, 0);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int r, int c, Set<String> visited, int area) {
        if (Math.min(r, c) < 0 || r >= grid.length || c >= grid[r].length ||
            grid[r][c] == 0 || visited.contains(r + "," +c)) {
            return 0;
        }

        visited.add(r + "," + c);
        area++;
        area += dfs(grid, r + 1, c, visited, 0);
        area += dfs(grid, r - 1, c, visited, 0);
        area += dfs(grid, r, c + 1, visited, 0);
        area += dfs(grid, r, c - 1, visited, 0);

        return area;
    }
}
