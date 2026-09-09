class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                int rightSum = total - nums[i];
                if (leftSum == rightSum) {
                    return i;
                }
                continue;
            }

            leftSum += nums[i - 1];
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}