class Solution {
    // Time complexity: O(row * col)
    // Space complexity: O(col)
    public int uniquePaths(int m, int n) {
        // NOTE: default int[] value is 0. Also you could use Arrays.fill() to fill in a specific value in an array!
        int[][] grid = new int[m][n];
        int[] prevRow = new int[n];
        
        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (col == n - 1) {
                    grid[row][col] = 1;
                    continue;
                }

                grid[row][col] = prevRow[col] + grid[row][col + 1];
            }
            prevRow = grid[row];
        }
        return grid[0][0];
    }
}
