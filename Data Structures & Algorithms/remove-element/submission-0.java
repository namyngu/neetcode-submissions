class Solution {
    public int removeElement(int[] nums, int val) {

        int k = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = Integer.MIN_VALUE;
                k--;
            }
        }

        // Shift values to left;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == Integer.MIN_VALUE) {
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
            }
        }

        return k;
    }
}