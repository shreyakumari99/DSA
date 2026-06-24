class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            // Add primary diagonal element
            sum += mat[i][i];
            // Add secondary diagonal element
            sum += mat[i][n - 1 - i];
        }
        
        // If n is odd, the middle element was added twice, so subtract it once
        if (n % 2 != 0) {
            sum -= mat[n / 2][n / 2];
        }
        
        return sum;
    }
}