class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int sum = 0;
        int l = 0;

        for (int r = 0; r < arr.length; r++) {
            if (r - l >= k) {
                sum -= arr[l];
                l++;
            }
            sum += arr[r];
            if ((r - l) == (k - 1)) {
                
                if ((sum / k) >= threshold) {
                    res++;
                }
            }
        }
        return res;
    }
}