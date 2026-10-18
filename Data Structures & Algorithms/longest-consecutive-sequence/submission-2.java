class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 0;
        for (Integer num : set) {
            // only check the start of a sequence.
            if (set.contains(num - 1)) {
                continue;
            }
            int curr = 1;
            while (set.contains(num + 1)) {
                curr++;
                num++;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
