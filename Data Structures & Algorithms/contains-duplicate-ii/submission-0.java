class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0;
        int r = l + 1;

        set.add(nums[l]);
        while (r < nums.length) {
            while (r - l <= k && r < nums.length) {
                if (set.contains(nums[r])) {
                    return true;
                }
                set.add(nums[r]);
                r++;
            }
            set.remove(nums[l]);
            l++;

        }
        return false;
    }
}