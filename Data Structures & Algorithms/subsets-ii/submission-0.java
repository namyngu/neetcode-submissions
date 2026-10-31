class Solution {
    Set<List<Integer>> outerSet;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        outerSet = new HashSet<>();
        dfs(nums, 0, new ArrayList<>());
        List<List<Integer>> res = new ArrayList<>(outerSet);
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> subset) {
        if (i >= nums.length) {
            subset.sort((a, b) -> a - b);
            outerSet.add(subset);
            return;
        }
        List<Integer> subset1 = new ArrayList<>(subset);
        List<Integer> subset2 = new ArrayList<>(subset);
        subset2.add(nums[i]);
        dfs(nums, i + 1, subset1);
        dfs(nums, i + 1, subset2);
    }
}
