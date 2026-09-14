// Intuition: If prefixSum[j] - prefixSum[i] = k, then the subarray from index i+1 to j has sum k.
// Time: O(n)
// Space: O(n)
// Prefix Sum + HashMap
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();    // {sum, count}
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            if (map.containsKey(target)) {
                res += map.get(target);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}