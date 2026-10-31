class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0, list, nums);
        return res;
    }

    public void helper(int i, List<Integer> list, int[] nums) {
        if (i >= n) {
            res.add(list);
            return;
        }
        List<Integer> list2 = new ArrayList<>(list);
        list2.add(nums[i]);
        helper(i + 1, list, nums);
        helper(i + 1, list2, nums);
    }
}
