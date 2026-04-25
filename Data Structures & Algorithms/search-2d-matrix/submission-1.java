class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int top = 0;
        int bot = matrix.length - 1;
        int mid = 0;

        while (top <= bot) {
            mid = top + (bot - top) / 2;

            if (target < matrix[mid][0]) {
                bot = mid - 1;
            }
            else if (target > matrix[mid][0]) {
                if (target < matrix[mid][n - 1]) {
                    // second binary search in that
                    int row = mid;
                    int l = 0;
                    int r = matrix[row].length - 1;
                    int midR;

                    while (l <= r) {
                        midR = l + (r - l) / 2;

                        if (target < matrix[row][midR]) {
                            r = midR - 1;
                        }
                        else if (target > matrix[row][midR]) {
                            l = midR + 1;
                        }
                        else {
                            return true;
                        }
                    }
                    return false;
                }

                else if(target == matrix[mid][n - 1]) {
                    return true;
                }
                
                top = mid + 1;
            }
            else {
                return true;
            } 
        }

        return false;
    }
}
