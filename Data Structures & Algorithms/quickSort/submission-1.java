// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        if (pairs.size() <= 1) {
            return pairs;
        }

        // sort the list
        sort(pairs, 0, pairs.size() - 1, pairs.size() - 1);

        return pairs;
    }

    private void sort(List<Pair> pairs, int l, int r, int pIndex) {
        if (r - l + 1 <= 1) {
            return;
        }

        Pair pivot = pairs.get(pIndex);
        int swap = l;
        int curr = l;

        while (curr <= r) {
            if (curr == pIndex) {
                // if curr pointer is at the pivot value, skip.
                curr++;
                continue;
            }

            if (pairs.get(curr).key < pivot.key) {
                Pair tmp = pairs.get(swap);
                pairs.set(swap, pairs.get(curr));
                pairs.set(curr, tmp);

                swap++;
            }

            curr++;
        }

        // Swap pivot with value at swap ptr.
        pairs.set(pIndex, pairs.get(swap));
        pairs.set(swap, pivot);

        sort(pairs, l, swap - 1, swap - 1);   // sort left side
        sort(pairs, swap + 1, r, r);          // sort right side
    }
}
