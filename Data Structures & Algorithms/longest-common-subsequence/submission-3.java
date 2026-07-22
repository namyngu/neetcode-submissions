class Solution {
    Map<String, Integer> visited = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        if (visited.containsKey(text1 + text2)) {
            return visited.get(text1 + text2);
        }

        if (text1.charAt(0) == text2.charAt(0)) {
            visited.put(text1 + text2, 1 + longestCommonSubsequence(text1.substring(1), text2.substring(1)));
        }
        else {
            visited.put(text1 + text2, 
                Math.max(longestCommonSubsequence(text1.substring(1), text2), longestCommonSubsequence(text1, text2.substring(1))));
        }
        return visited.get(text1 + text2);
    }

}
