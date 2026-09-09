// Solve in O(n) without using division.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProd = new int[nums.length];
        int[] postfixProd = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixProd[i] = 1;
                continue;
                
            }
            prefixProd[i] = nums[i - 1] * prefixProd[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfixProd[i] = 1;
                continue;
            }
            postfixProd[i] = nums[i + 1] * postfixProd[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefixProd[i] * postfixProd[i];
        }
        return res;
    }
}  
