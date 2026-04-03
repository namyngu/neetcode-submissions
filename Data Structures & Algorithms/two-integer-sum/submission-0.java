class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueIndex = new HashMap<>(); // num, index

        for (int i = nums.length - 1; i >= 0; i--) {
            int difference = target - nums[i];
            if (valueIndex.containsKey(difference)) {
                return new int[] {i, valueIndex.get(difference)};
            }

            valueIndex.put(nums[i], i);
        }

        return new int[] {};
    }

}
