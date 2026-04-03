class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean containsDupe = !set.add(nums[i]);

            if (containsDupe) {
                return true;
            }
        }
        return false;
    }
}