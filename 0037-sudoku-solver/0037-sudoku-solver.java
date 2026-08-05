class Solution {
    public void solveSudoku(char[][] board) {
        sudoko(board);
    }
    public boolean sudoko(char[][] board) {
        for(int i=0 ; i<board.length ; i++) {
            for(int j=0 ; j<board[0].length ; j++) {
                if(board[i][j] == '.') {
                    for(int val=1 ; val<=9 ; val++) {
                        if(isValid(i , j , val , board)) {
                            board[i][j] = (char) (val + '0');
                            if(sudoko(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int row , int col , int val, char[][] board) {
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