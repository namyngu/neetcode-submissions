// This is the Top-Down dynamic programming approach.
// Uses recursion with cache
// Time complexity: O(m*n)
// Space complexity: O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        Map<String, Integer> cache = new HashMap<>();
        return dfs(0, 0, m, n, cache);
    }
    // row and col is the current row and col you are in.
    public int dfs(int row, int col, int m, int n, Map<String, Integer> cache) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }
        if (cache.containsKey(row + "," + col)) {
            return cache.get(row + "," + col);
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        cache.put(row + "," + col, 
        dfs(row + 1, col, m, n, cache) + dfs(row, col + 1, m, n, cache));
        return cache.get(row + "," + col);
    }
}
