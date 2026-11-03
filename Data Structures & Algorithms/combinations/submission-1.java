// OPTIMAL
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(n, k, 1, 1, new ArrayList<>());
        return res;
    }

    public void dfs(int n, int k, int digit, int i, List<Integer> subset) {
        if (digit > k) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for (; i <= n; i++) {
            subset.add(i);
            dfs(n, k, digit + 1, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}