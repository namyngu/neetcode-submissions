class Solution {
    // Brute force solution:
    // Time: O(n^2)
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int L = 0; L < nums.length; L++) {
            int sum = 0;
            for (int R = L; R < nums.length; R++) {
                sum += nums[R];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }
}