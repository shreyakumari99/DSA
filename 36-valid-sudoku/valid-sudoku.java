class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use array of boolean flags or sets for fast O(1) lookups
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                
                // Skip empty cells
                if (val == '.') {
                    continue;
                }

                int num = val - '1'; // Convert char '1'-'9' to index 0-8
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If digit was already seen in row, column, or 3x3 box, board is invalid
                if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                    return false;
                }

                // Mark digit as seen
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true;
    }
}