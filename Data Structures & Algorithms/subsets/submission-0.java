class Solution {
    List<List<Integer>> allPaths = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> currPath = new ArrayList<>();
        path(nums, 0, currPath);
        return allPaths;
    }

    private void path(int[] nums, int currIndex, List<Integer> currPath) {
        if (currIndex > nums.length - 1) {
            allPaths.add(currPath);
            return;
        }

        int currNum = nums[currIndex];
        currIndex++;
        List<Integer> path1 = new ArrayList<>(currPath);
        List<Integer> path2 = new ArrayList<>(currPath);
        path1.add(currNum);

        path(nums, currIndex, path1);
        path(nums, currIndex, path2);
    }
}
