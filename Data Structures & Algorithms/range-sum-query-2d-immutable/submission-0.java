class NumMatrix {
    int[][] matrix;
    int[][] prefSum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        
        // Initialize prefSum matrix
        prefSum = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < prefSum.length; row++) {
            for (int col = 0; col < prefSum[0].length; col++) {
                if (col == 0) {
                    prefSum[row][col] = matrix[row][col];
                    continue;
                }
                prefSum[row][col] = prefSum[row][col - 1] + matrix[row][col];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int row = row1; row <= row2; row++) {
            if (col1 == 0) {
                sum += prefSum[row][col2];
                continue;
            }
            sum += prefSum[row][col2] - prefSum[row][col1 - 1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */