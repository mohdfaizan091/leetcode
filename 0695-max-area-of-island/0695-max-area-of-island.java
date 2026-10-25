class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int ans = 0;

        boolean[][] isVisited = new boolean[row][col];
        for(int i=0 ; i<row ; i++) {
            for(int j=0 ; j<col ; j++) {
                if(grid[i][j] == 1 && !isVisited[i][j]) {
                    maxArea = 1;
                    isVisited[i][j] = true;
                    dfs(grid , isVisited , i , j);
                    ans = Math.max(ans , maxArea);
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid , boolean[][] isvis , int row , int col) {

        if(row < 0 || col > grid[0].length || row == grid.length && col == grid[0].length) return;
        // up ^
        if(row > 0 && !isvis[row - 1][col] && grid[row - 1][col] == 1) {
            isvis[row - 1][col] = true;
            maxArea++;
            dfs(grid , isvis , row - 1 , col);
        } 

        // down |
        if(row < grid.length - 1 && !isvis[row + 1][col] && grid[row + 1][col] == 1) {
            isvis[row + 1][col] = true;
            maxArea++;
            dfs(grid , isvis , row + 1 , col);
        } 

        //left
        if(col > 0 && !isvis[row][col - 1] && grid[row][col - 1] == 1) {
            isvis[row][col - 1] = true;
            maxArea++;
            dfs(grid , isvis , row , col - 1);
        }

        // right
        if(col < grid[0].length - 1 && !isvis[row][col + 1] && grid[row][col + 1] == 1) {
            isvis[row][col + 1] = true;
            maxArea++;
            dfs(grid , isvis , row , col + 1);
        }
    }
}