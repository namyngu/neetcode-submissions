class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] postfixSum = new int[nums.length];

        for (int i = 0 ; i < nums.length; i++) {
            if (i == 0) {
                prefixSum[i] = 0;
                continue;
            }
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (int i = nums.length - 1 ; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfixSum[i] = 0;
                continue;
            }
            postfixSum[i] = postfixSum[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefixSum[i] == postfixSum[i]) {
                return i;
            }
        }
        return -1;
    }
}