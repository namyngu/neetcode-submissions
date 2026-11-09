// OPTIMAL - saves space overhead by avoid deep copying hashmap and permutations in each recursive call.
class Solution {
    List<List<Integer>> res;
    Map<Integer, Integer> map;       // number -> count
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        map = new HashMap<>();
        // build frequency hashmap
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        backtrack(nums, map, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, Map<Integer, Integer> map, List<Integer> curPerm) {
        if (curPerm.size() == nums.length) {
            res.add(new ArrayList<>(curPerm));
            return;
        }

        for (Integer num : map.keySet()) {
            if (map.get(num) == 0) {
                continue;
            }
            curPerm.add(num);
            map.put(num, map.get(num) - 1);
            backtrack(nums, map, curPerm);
            // save memory overhead by reusing map and current permutation in each recursive call.
            map.put(num, map.get(num) + 1);
            curPerm.remove(curPerm.size() - 1);
        }
    }
}