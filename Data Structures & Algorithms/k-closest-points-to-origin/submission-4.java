class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Edge case
        if (k >= points.length || points == null) {
            return points;
        }

        // Sort points array.
        return quickSort(points, 0, points.length - 1, k);
    }

    private int[][] quickSort(int[][] points, int s, int e, int k) {
        // Edge case
        if (points == null || e > points.length - 1 || s > e) {
            return Arrays.copyOfRange(points, 0, k);
        }
        // base case.
        if (e - s + 1 <= 1) {
            return Arrays.copyOfRange(points, 0, k);
        }

        int[] pivot = points[e];    // pick pivot at last element.
        double pDist = Math.sqrt(Math.pow(pivot[0],2) + Math.pow(pivot[1], 2));     // sqrt(x^2 + y^2)
        int swap = s;

        for (int i = s; i < e ; i++) {   // not including the pivot index
            double pointDist = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));

            if (pointDist <= pDist) {
                int[] tmp = points[swap];
                points[swap] = points[i];
                points[i] = tmp;

                swap++;
            }
        }

        // Swap pivot with the swap ptr.
        points[e] = points[swap];
        points[swap] = pivot;
        if (swap == k) {
            return Arrays.copyOfRange(points, 0, k);
        }
        else if (swap < k) {
            return quickSort(points, swap + 1, e, k);
        }
        else {
            return quickSort(points, s, swap - 1, k);
        }
    }
}

