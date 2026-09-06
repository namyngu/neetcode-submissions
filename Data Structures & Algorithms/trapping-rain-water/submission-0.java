class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 1) {
            return 0;
        }
        int LMax = 0;
        int RMax = 0;
        int L = 0;
        int R = n - 1;
        int mid = L;
        int res = 0;

        while (L < R) {
            LMax = Math.max(LMax, height[L]);
            RMax = Math.max(RMax, height[R]);
            res += Math.max(Math.min(LMax, RMax) - height[mid], 0);   // water at mid

            if (LMax <= RMax) {
                L++;
                mid = L;
            }
            else {
                R--;
                mid = R;
            }
        }
        return res;
    }
}
