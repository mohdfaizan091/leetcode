class Solution {
    int min = Integer.MAX_VALUE;
    boolean[][][] visited; 

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        visited = new boolean[m][n][1024]; 
        
        traverseMaze(grid, 0, 0, grid[0][0]);
        return min;
    }

    public void traverseMaze(int[][] grid, int row, int col, int ans) {
    
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            min = Math.min(min, ans);
            return;
        }

        if (visited[row][col][ans]) {
            return;
        }
        visited[row][col][ans] = true;

        if (row + 1 < grid.length) {
            traverseMaze(grid, row + 1, col, ans ^ grid[row + 1][col]);
        }

        if (col + 1 < grid[0].length) {
            traverseMaze(grid, row, col + 1, ans ^ grid[row][col + 1]);
        }
    }
}
