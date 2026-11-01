// Time taken: 17:23
// This is actually optimal, u might be good :)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        dfs(nums, target, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int[] nums, int target, List<Integer> subset, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (target < 0) {
            return;
        }

        for (; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, target - nums[i], subset, i);
            subset.remove(subset.size() - 1);
        }
    }
}
