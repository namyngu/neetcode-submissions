class Solution {
    public int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int LMax = 0, RMax = 0;
        int L = 0;
        int R = height.length - 1;
        int mid = L;
        int res = 0;

        while (L < R) {
            res += Math.max(Math.min(LMax, RMax) - height[mid], 0);   // water at mid
            LMax = Math.max(LMax, height[L]);
            RMax = Math.max(RMax, height[R]);

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
