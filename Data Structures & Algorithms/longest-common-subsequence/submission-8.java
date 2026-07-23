class Solution {
    Map<String, Integer> visited = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
    return dp(text1, text2, 0, 0);
  }

  public int dp(String text1, String text2, int i, int j) {
    if (i >= text1.length() || j >= text2.length()) {
        return 0;
    }
    if (visited.containsKey(i + "," + j)) {
        return visited.get(i + "," + j);
    }

    if (text1.charAt(i) == text2.charAt(j)) {
        visited.put(
            i + "," + j, 1 + dp(text1, text2, i + 1, j + 1)
        );
    } else {
        visited.put(
            i + "," + j,
            Math.max(
                dp(text1, text2, i + 1, j),
                dp(text1, text2, i, j + 1)
            )
        );
    }
    return visited.get(i + "," + j);
  }
}