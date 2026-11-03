class Solution {
    List<String> res;
    Map<Integer, char[]> map;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        // Map digit -> chars
        map = new HashMap<>();
        for (int i = 2; i <= 6; i++) {
            char c1 = (char) ((i - 2) * 3 + 'a');
            char[] chars = new char[]{c1, (char) (c1 + 1), (char) (c1 + 2)};
            map.put(i, chars);
        }
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});

        res = new ArrayList<>();
        dfs("", digits, 0);
        return res;
    }

    public void dfs(String curStr, String digits, int i) {
        if (i >= digits.length()) {
            res.add(curStr);
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(i));
        for (char c : map.get(digit)) {
            dfs(curStr + c, digits, i + 1);
        }
    }
}
