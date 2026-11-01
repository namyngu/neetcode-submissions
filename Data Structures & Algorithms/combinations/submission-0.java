// n choose k
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(1, 1, k, n, new ArrayList<>());
        return res;
    }

    public void dfs(int digit, int i, int k, int n, List<Integer> combination) {
        if (digit > k) {
            res.add(combination);
            return;
        }

        while (i <= n) {
            List<Integer> newCombination = new ArrayList<>(combination);
            newCombination.add(i);
            dfs(digit + 1, i + 1, k, n, newCombination);
            i++;
        }
    }
}