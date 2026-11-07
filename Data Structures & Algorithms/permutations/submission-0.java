class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            input.add(nums[i]);
        }
        backtracking(input, new ArrayList<>());
        return res;
    }

    public void backtracking(List<Integer> nums, List<Integer> curPerm) {
        if (nums.isEmpty()) {
            res.add(curPerm);
            return;
        }
        for (int j = 0; j < nums.size(); j++) {
            List<Integer> copyPerm = new ArrayList<>(curPerm);
            copyPerm.add(nums.get(j));
            List<Integer> copyNums = new ArrayList<>(nums);
            copyNums.remove(j);
            backtracking(copyNums, copyPerm);
        }
    }
}
