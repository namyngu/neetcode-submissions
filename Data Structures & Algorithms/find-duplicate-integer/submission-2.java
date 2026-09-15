class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        }
        while (nums[slow] != nums[fast]);

        int slow2 = 0;
        while (nums[slow] != nums[slow2]) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return nums[slow];
    }
}
