class Solution {
    public int reverseBits(int n) {
        int revN = 0;
        for (int i = 0; i < 31; i++) {
            if ((n & 1) == 1) {
                revN += 1;
            }
            revN = revN << 1;
            n = n >> 1;
        }

        if ((n & 1) == 1) {
            revN++;
        }
        return revN;
    }
}
