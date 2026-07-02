class Solution {
    Map<Integer, Integer> cache;      // [i : max money at house i]
    public int rob(int[] nums) {
        cache = new HashMap<>();
        return decision(nums, 0);
    }

    public int decision(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        int rob = nums[i] + decision(nums, i + 2);
        int skip = decision(nums, i + 1);
        cache.put(i, Math.max(rob, skip));

        return cache.get(i);
    }
}
