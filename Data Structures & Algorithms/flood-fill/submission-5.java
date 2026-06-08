class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origin = image[sr][sc];
        Set<String> visited = new HashSet<>();
        dfs(image, sr, sc, color, origin, visited);

        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int origin, Set<String> visited) {
        if (Math.min(r, c) < 0 || r >= image.length || c >= image[r].length ||
        visited.contains(r + "," + c) || image[r][c] != origin) {
            return;
        }

        image[r][c] = color;
        visited.add(r + "," + c);

        dfs(image, r + 1, c, color, origin, visited);    // move down
        dfs(image, r - 1, c, color, origin, visited);    // move up
        dfs(image, r, c + 1, color, origin, visited);    // move right
        dfs(image, r, c - 1, color, origin, visited);    // move left
    }
}