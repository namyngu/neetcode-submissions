class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] tmpArr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            tmpArr[i] = nums[i];
            tmpArr[i + n] = nums[i];
        }

        return tmpArr;
    }
}