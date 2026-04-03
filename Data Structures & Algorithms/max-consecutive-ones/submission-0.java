class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        if (nums[0] == 1) {
            count++;
        }

        maxCount = Math.max(count, maxCount);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1 && nums[i-1] == 1) {
                count++;
            }
            else if(nums[i] == 1) {
                count = 1;
            }
            else {
                count = 0;
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}