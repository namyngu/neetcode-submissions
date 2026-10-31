class Solution {
    Set<List<Integer>> outerSet;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        outerSet = new HashSet<>();
        dfs(nums, 0, new ArrayList<>());
        List<List<Integer>> res = new ArrayList<>(outerSet);
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> subset1) {
        if (i >= nums.length) {
            subset1.sort((a, b) -> a - b);
            outerSet.add(subset1);
            return;
        }
        List<Integer> subset2 = new ArrayList<>(subset1);
        subset2.add(nums[i]);
        dfs(nums, i + 1, subset1);
        dfs(nums, i + 1, subset2);
    }
}
