class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), new HashSet<>());
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> subset1, Set<Integer> exclude) {
        if (i >= nums.length) {
            res.add(subset1);
            return;
        }
        if (exclude.contains(nums[i])) {
            dfs(nums, i + 1, subset1, exclude);
            return;
        }
        List<Integer> subset2 = new ArrayList<>(subset1);
        subset1.add(nums[i]);
        dfs(nums, i + 1, subset1, exclude);
        Set<Integer> exclude2 = new HashSet<>(exclude);
        exclude2.add(nums[i]);
        dfs(nums, i + 1, subset2, exclude2);
    }
}
