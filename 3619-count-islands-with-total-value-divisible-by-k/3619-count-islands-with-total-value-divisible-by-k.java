class Solution {
    public int countIslands(int[][] grid, int k) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        boolean[][] visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    long totalValue = dfs(grid, visited, i, j);
                    
                    if (totalValue % k == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private long dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] <= 0) {
            return 0;
        }
        
        visited[r][c] = true;
        
      
        long sum = grid[r][c];
        sum += dfs(grid, visited, r - 1, c); // Up
        sum += dfs(grid, visited, r + 1, c); // Down
        sum += dfs(grid, visited, r, c - 1); // Left
        sum += dfs(grid, visited, r, c + 1); // Right
        
        return sum;
    }
}
