class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> charFreq = new HashMap<>();
        int res = 0;
        int l = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            charFreq.put(s.charAt(r), charFreq.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, charFreq.get(s.charAt(r)));

            // Check if window is valid.
            while (r - l + 1 - maxFreq > k) {
                charFreq.put(s.charAt(l), charFreq.getOrDefault(s.charAt(l), 0) - 1);
                // update max freq.
                maxFreq = 0;
                for (Integer freq : charFreq.values()) {
                    maxFreq = Math.max(maxFreq, freq);
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
