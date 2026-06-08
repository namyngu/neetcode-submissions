class Solution {
    int count = 0;

    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '0' || visited.contains(r + "," + c)) {
                    continue;
                }
                count++;
                markLandAsVisited(grid, r, c, visited);
            }
        }
        return count;
    }

    public void markLandAsVisited(char[][] grid, int r, int c, Set<String> visited) {
        if (Math.min(r ,c) < 0 || r >= grid.length || c >= grid[r].length || 
            grid[r][c] == '0' || visited.contains(r + "," + c)) {
                return;
        }
        
        visited.add(r + "," + c);
        markLandAsVisited(grid, r + 1, c, visited);     // Move up
        markLandAsVisited(grid, r - 1, c, visited);     // Move down
        markLandAsVisited(grid, r, c + 1, visited);     // Move right
        markLandAsVisited(grid, r, c - 1, visited);     // Move left
    }
}
