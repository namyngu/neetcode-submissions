class Solution {

    public int climbStairs(int n) {
        Map<Integer,Integer> cache = new HashMap<>();

        return dfs(n, cache);
    }

    // recursive function.
    public int dfs(int n, Map<Integer,Integer> cache) {
        int res = 0;

        if (n > 1) {
            // take one step
            if (cache.containsKey(n - 1)) {
                res += cache.get(n - 1);
            }
            else {
                int tmp = dfs(n - 1, cache);
                cache.put(n - 1, tmp);
                res += tmp;
            }

            // take two steps 
            if (cache.containsKey(n - 2)) {
                res += cache.get(n - 2);
            }
            else {
                int tmp = dfs(n - 2, cache);
                cache.put(n - 2, tmp);
                res += tmp;
            }

        }
        else {
            res = 1;  // if n = 1 or n = 0 result is the same.
        }

        return res;
    }
}
