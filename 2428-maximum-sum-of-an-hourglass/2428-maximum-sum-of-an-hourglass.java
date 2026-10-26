class Solution {
    public int maxSum(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        int[][] ans = new int[row][col];

        for(int i=0 ; i<row - 2 ; i++) {
            for(int j=0 ; j<col - 2 ; j++) {
                ans[i][j] = hourGlass(grid , i , j);
            }
        }

        int max = -1;
        
        for(int i=0 ; i<row ; i++) {
            for(int j=0 ; j<col ; j++) {
                max = Math.max(max , ans[i][j]);
            }
        }
        return max;
    }

    public int hourGlass(int[][] grid , int row , int col) {
        int val = 0;

        for(int i=row ; i<row + 3 ; i++) {
            for (int j = col; j < col + 3; j++) {
            
                if (i == row + 1 && (j == col || j == col + 2)) {
                    continue;
                }
                val += grid[i][j];
            }
        }
        return val;
    }
}