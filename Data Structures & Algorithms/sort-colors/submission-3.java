class Solution {
    public void sortColors(int[] nums) {
        int[] count = {0, 0, 0};

        for (int color : nums) {
            count[color] = count[color] + 1;
        }

        int i = 0;
        for (int j = 0; j < count.length; j++) {
            for (int k = 0; k < count[j]; k++) {
                nums[i] = j;
                i++;
            }
        }
    }
}