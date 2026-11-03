class Solution {
    List<String> res;
    Map<Integer, char[]> map;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        // Map digit -> chars
        map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
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
