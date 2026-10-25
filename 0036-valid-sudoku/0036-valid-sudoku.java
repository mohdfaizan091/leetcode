class Solution {
    public boolean isValidSudoku(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        for(int i=0 ; i<row ; i++) {
            for(int j=0 ; j<col ; j++) {
                if(board[i][j] != '.') {
                    if(!validSudoko(board , i , j)) return false;
                }
            }
        }
        return true;
    }
    public boolean validSudoko(char[][] board , int row , int col) {
        int m = board.length;
        int n = board[0].length;

        char checkChar = board[row][col];

        // row
        for(int i=0 ; i<n ; i++) {
            if(i != col && board[row][i] == checkChar) return false;
        }

        //col
        for(int i=0 ; i<m ; i++) {
            if(i != row && board[i][col] == checkChar) return false;
        }

        // diagonal
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if ((i != row || j != col) && board[i][j] == checkChar) {
                    return false;
                }
            }
        }

        return true;
    }
}