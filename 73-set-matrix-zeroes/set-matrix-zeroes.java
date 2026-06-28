class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col0 = true; // Tracks if the first column needs to be zeroed

        // Step 1: Scan the matrix and use the first row/col as markers
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = false; // First column needs to become 0
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark row i
                    matrix[0][j] = 0; // Mark column j
                }
            }
        }

        // Step 2: Iterate backwards to update the cells based on the markers
        // We go backwards so we don't accidentally ruin our markers prematurely
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (!col0) {
                matrix[i][0] = 0; // Update the first column if needed
            }
        }
    }
}
