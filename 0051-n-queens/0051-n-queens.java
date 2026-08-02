class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] arr = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                arr[i][j] = '.';
            }
        }
        Queen(ans , arr  , 0);
        return ans;
    }

    public void Queen(List<List<String>> ans , char[][] arr , int row) {
        if(row == arr.length) {
            ans.add(makeString(arr));
            return;
        }
        for(int j=0 ; j<arr.length ; j++) {
            if(isSafe(arr , row , j)) {
                arr[row][j] = 'Q';
                Queen(ans , arr, row + 1);
                arr[row][j] = '.';
            }
        }
    }

    public List<String> makeString(char[][] arr) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            temp.add(new String(arr[i]));
        }
        return temp;
    }
    public boolean isSafe(char[][] matrix, int row, int col) {
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