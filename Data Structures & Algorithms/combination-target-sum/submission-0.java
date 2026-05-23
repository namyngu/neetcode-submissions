class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> set = new ArrayList<>();
        combinationSumHelper(nums, 0, target, 0, set);
        return res;
    }

    private void combinationSumHelper(int[] nums, int i, int target, int sum, List<Integer> set) {
        if (sum == target) {
            res.add(set);
            return;
        }
        if (i >= nums.length || sum > target) {
            return;
        }

        List<Integer> newSet = new ArrayList<>(set);
        newSet.add(nums[i]);
        combinationSumHelper(nums, i, target, sum + nums[i], newSet);   // path 1 add current number to set.
        combinationSumHelper(nums, i+1, target, sum, set);              // path 2 don't add anymore of this number.
    }
}
