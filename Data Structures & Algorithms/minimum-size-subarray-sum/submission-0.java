class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int l = 0;
        int r = 0;
        int res = Integer.MAX_VALUE;

        for (r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target && l <= r) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }

        // Edge case - no solution
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }
}