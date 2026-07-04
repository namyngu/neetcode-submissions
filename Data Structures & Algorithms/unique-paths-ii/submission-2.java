class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] prevRow = new int[obstacleGrid[0].length];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        for (int row = m- 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (obstacleGrid[row][col] == 1) {
                    prevRow[col] = 0;
                    continue;
                }
                if (col == n - 1 && row == m - 1) {
                    prevRow[col] = 1;
                }
                if (col == obstacleGrid[0].length - 1) {
                    continue;
                }
                prevRow[col] = prevRow[col] + prevRow[col + 1];
            }
        }
        return prevRow[0];
    }
}