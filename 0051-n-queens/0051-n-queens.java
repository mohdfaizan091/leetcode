class Solution {
    public List<List<String>> solveNQueens(int n) {
        Character[][] board = new Character[n][n];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> finalQuePosition = new ArrayList<>();
        Queen(finalQuePosition , board , 0);
        return finalQuePosition;
    }

    public void Queen(List<List<String>> finalQuePosition , Character[][] board , int row) {
        // base case 

        if(row == board.length) {
            List<String> currPosQueen = new ArrayList<>();
            for(int i=0 ; i<board.length ; i++) {
                String s = "";
                for(int j=0 ; j<board.length ; j++) {
                    s+=board[i][j];
                }
                currPosQueen.add(s);
            }
            finalQuePosition.add(new ArrayList<>(currPosQueen));
        }


        for(int col=0 ; col<board.length ; col++) {
            if(isSafePosition(board , row , col)) {
                board[row][col] = 'Q';
                Queen(finalQuePosition , board , row + 1);
                //backTrack
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafePosition(Character[][] matrix, int row, int col) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][col] == 'Q')
                return false;
        }

        for (int i = 0; i < n; i++) {
            if (matrix[row][i] == 'Q')
                return false;
        }

        int x = row;
        int y = col;

        while (x >= 0 && y >= 0) {
            if (matrix[x][y] == 'Q')
                return false;
            x--;
            y--;
        }

        x = row;
        y = col;

        while (x >= 0 && y < n) {
            if (matrix[x][y] == 'Q')
                return false;
            x--;
            y++;
        }

        return true;
    }
}