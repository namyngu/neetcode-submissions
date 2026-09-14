// Intuition: If currentPrefixSum - previousPrefixSum = k, then previousPrefixSum = currentPrefixSum - k
// meaning the subarray i+1 to j sum up to k.
// Time: O(n)
// Space: O(n)
// Prefix Sum + HashMap
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();    // {previousPrefixSum, count}
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            res += map.getOrDefault(target, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}