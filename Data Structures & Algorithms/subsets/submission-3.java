class Solution {
    List<List<Integer>> allPaths = new ArrayList<>();
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        path(nums, 0, new ArrayList<>());
        return allPaths;
    }

    private void path(int[] nums, int i, List<Integer> path1) {
        if (i > nums.length - 1) {
            allPaths.add(path1);
            return;
        }
        List<Integer> path2 = new ArrayList<>(path1);
        path2.add(nums[i]);
        path(nums, i + 1, path1);
        path(nums, i + 1, path2);
    }
}
