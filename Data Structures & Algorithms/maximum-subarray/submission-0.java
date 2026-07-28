class Solution {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int currSum = 0;

        int L, R = 0;

        while (R < nums.length) {
            if (currSum < 0) {
                L = R;
                currSum = nums[R];
            }
            else {
                currSum += nums[R];
                
            }
            maxSum = Math.max(maxSum, currSum);
            R++;
        }
        return maxSum;
    }
}
