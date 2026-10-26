class Solution { 
    public void gameOfLife(int[][] board) { 
        int row = board.length; 
        int col = board[0].length; 
        
        int[][] copy = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for(int i=0 ; i<row ; i++) { 
            for(int j=0 ; j<col ; j++) { 
                if(copy[i][j] == 0) { 
                    if(checkCanWeMakeLive(copy , i , j)) {
                        board[i][j] = 1; 
                    } 
                } else { 
                    if(!checkCanRemainLive(copy , i , j)) { 
                        board[i][j] = 0; 
                    } 
                } 
            } 
        } 
    } 

    public boolean checkCanWeMakeLive(int[][] board , int row , int col) { 
        int countLiveCell = 0; 
        //up 
        if(row > 0) { 
            if(board[row - 1][col] == 1) countLiveCell++; 
        } 
        //down 
        if(row < board.length - 1) { 
            if(board[row + 1][col] == 1) countLiveCell++; 
        } 
        //left 
        if(col > 0) { 
            if(board[row][col - 1] == 1) countLiveCell++; 
        } 
        //right 
        if(col < board[0].length - 1) { 
            if(board[row][col + 1] == 1) countLiveCell++; 
        } 
        //leftupdiagonal 
        if(row > 0 && col > 0) { 
            if(board[row - 1][col - 1] == 1) countLiveCell++; 
        } 
        //rightupdiagonal 
        if(row > 0 && col < board[0].length - 1) { 
            if(board[row - 1][col + 1] == 1) countLiveCell++; 
        } 
        //leftdowndiagonal 
        if(row < board.length - 1 && col > 0) { 
            if(board[row + 1][col - 1] == 1) countLiveCell++; 
        } 
        //rightdowndiagonal 
        if(row < board.length - 1 && col < board[0].length - 1) { 
            if(board[row + 1][col + 1] == 1) countLiveCell++; 
        } 
        
        return countLiveCell == 3; 
    } 

    public boolean checkCanRemainLive(int[][] board , int row , int col) { 
        int countLiveCell = 0;

        //up 
        if(row > 0) { 
            if(board[row - 1][col] == 1) countLiveCell++; 
        } 
        //down 
        if(row < board.length - 1) { 
            if(board[row + 1][col] == 1) countLiveCell++; 
        } 
        //left 
        if(col > 0) { 
            if(board[row][col - 1] == 1) countLiveCell++; 
        } 
        //right 
        if(col < board[0].length - 1) { 
            if(board[row][col + 1] == 1) countLiveCell++; 
        } 
        //leftupdiagonal 
        if(row > 0 && col > 0) { 
            if(board[row - 1][col - 1] == 1) countLiveCell++; 
        } 
        //rightupdiagonal 
        if(row > 0 && col < board[0].length - 1) { 
            if(board[row - 1][col + 1] == 1) countLiveCell++; 
        } 
        //leftdowndiagonal 
        if(row < board.length - 1 && col > 0) { 
            if(board[row + 1][col - 1] == 1) countLiveCell++; 
        } 
        //rightdowndiagonal 
        
        if(row < board.length - 1 && col < board[0].length - 1) { 
            if(board[row + 1][col + 1] == 1) countLiveCell++; 
        } 
        return countLiveCell == 2 || countLiveCell == 3 ; 
    } 
}
