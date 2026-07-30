// Intuition: At each index i, perform Kadane's algorithm as if it's the start of the full array.
// Wrapping any elements that loops back.
// Time Complexity: O(n^2) - not ideal.
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;
        int L, R = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            currSum = 0;
            for (L = i, R = i; R < i + n; R++) {
                if (currSum < 0) {
                    currSum = 0;
                    L = R;
                }
                currSum += nums[R % n];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
}