class Solution {
    public void solveSudoku(char[][] board) {
        Solve(board);
    }

    public boolean Solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == '.') {
                    for (int val = 1; val <= 9; val++) {
                        if (isValidNo(val, board, row, col)) {
                            board[row][col] = (char) (val + '0'); // convert int 1–9 to char '1'–'9'

                            if (Solve(board)) {
                                return true; // found solution, stop
                            }

                            // backtrack
                            board[row][col] = '.';
                        }
                    }
                    return false; // no valid number here → backtrack
                }
            }
        }
        return true; // no empty cell left → solved
    }

    public boolean isValidNo(int val, char[][] board, int row, int col) {
        char ch = (char) (val + '0'); // convert int 1–9 to char '1'–'9'

        // row wise checking
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.' && board[row][i] == ch) {
                return false;
            }
        }

        // col wise checking
        for (int j = 0; j < 9; j++) {
            if (board[j][col] != '.' && board[j][col] == ch) {
                return false;
            }
        }

        // grid wise checking

        //finding the block of row and col
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] != '.' &&
                    board[startRow + i][startCol + j] == ch) {
                    return false;
                }
            }
        }

        // if no condition violates, val is valid
        return true;
    }
}