// Can you save space overhead by avoiding deep copying map and permutations in each recursive call?
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        // build frequency hashmap
        Map<Integer, Integer> map = new HashMap<>();      // number -> count
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        backtrack(map, new ArrayList<>());
        return res;
    }

    public void backtrack(Map<Integer, Integer> map, List<Integer> curPerm) {
        if (map.isEmpty()) {
            res.add(curPerm);
            return;
        }

        for (Integer num : map.keySet()) {
            List<Integer> copyPerm = new ArrayList<>(curPerm);
            Map<Integer, Integer> copyMap = new HashMap<>(map);
            copyPerm.add(num);
            copyMap.put(num, copyMap.get(num) - 1);
            if (copyMap.get(num) == 0) {
                copyMap.remove(num);
            }
            backtrack(copyMap, copyPerm);
        }
    }
}