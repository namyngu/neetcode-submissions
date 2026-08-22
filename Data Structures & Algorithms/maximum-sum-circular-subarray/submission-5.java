// Intuition: Use Kadane's algo to figure out both the max sum subarray and min sum subarray.
// Then use Math.max(Total - minSumSubarray, maxSumSubarray) to figure out the actual maxSumSubarray.
// Time Complexity: O(n)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;        //  current max including current element.
        int globMax = nums[0];  //  global max
        int currMin = 0;
        int globMin = nums[0];
        int total = 0;          // sum of all elements

        for (int i = 0; i < nums.length; i++) {
            currMax += nums[i];
            currMax = Math.max(currMax, nums[i]);
            globMax = Math.max(currMax, globMax);

            currMin += nums[i];
            currMin = Math.min(currMin, nums[i]);
            globMin = Math.min(currMin, globMin);

            total += nums[i];
        }

        // edge case - all numbers in array are negative
        // thus total - globMin = 0 which is greater than globMax (always negative)
        if (globMax < 0) {
            return globMax;
        }
        
        globMax = Math.max(globMax, total - globMin);
        return globMax;
    }
}