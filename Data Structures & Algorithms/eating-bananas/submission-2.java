class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // max k is equal to largest pile.
        // min k is 1.
        
        Arrays.sort(piles);

        int k = piles[piles.length - 1];

        int l = 1;
        int r = piles[piles.length - 1];
        int mid = k;

        while (l <= r) {
            mid = l + (r - l) / 2;

            if (canEatBananas(mid, piles, h) > 0) {
                // k needs to be larger.
                l = mid + 1;
            }
            else if (canEatBananas(mid, piles, h) < 0) {
                // check if k needs to be smaller, but is valid.
                k = Math.min(k, mid);
                r = mid - 1;
            }
            else {
                // k could still be smaller (especially for really large numbers!).
                k = Math.min(k, mid);
                r = mid - 1;
            }
        }

        return k;
    }

    public int canEatBananas(int k, int[] piles, int h) {
        int time = 0;

        for (int i = 0; i < piles.length; i++) {
            time = time + (int) Math.ceil(piles[i] / (double) k);
        }

        if (time > h) {
            return 1;
        }
        else if (time < h) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
