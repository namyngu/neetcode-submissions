// Break into subproblems
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return backtrack(nums, 0);
    }

    public List<List<Integer>> backtrack(int[] nums, int i) {
        if (i == nums.length) {
            List<List<Integer>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());
            return empty;
        }

        List<List<Integer>> permutations = backtrack(nums, i + 1);
        List<List<Integer>> res = new ArrayList<>();    // a copy of permutations with the new num inserted @ each index.
        for (List<Integer> perm : permutations) {
            for (int j = 0; j < perm.size() + 1; j++) {
                List<Integer> copyP = new ArrayList<>(perm);
                copyP.add(j, nums[i]);
                res.add(copyP);
            }
        }
        return res;
    }
}
