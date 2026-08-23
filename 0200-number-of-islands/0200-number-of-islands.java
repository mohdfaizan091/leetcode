class Solution {
    public int numIslands(char[][] grid) {
        int bfs = breadthFirstSearch(grid);
        int dfs = depthFirstSearch(grid);
        return dfs;
    }
    public int breadthFirstSearch(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        boolean[][] isVisited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]) {
                    count++;
                    bfs(grid, isVisited, i, j);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, boolean[][] isVisited, int row, int col) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{row, col});
        isVisited[row][col] = true;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(q.size() > 0) {

            int[] current = q.remove();

            int r = current[0];
            int c = current[1];

            for(int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1' && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
    public int depthFirstSearch(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        boolean[][] isVisited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]) {
                    count++;
                    dfs(grid, isVisited, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid , boolean[][] isVisited , int row , int col) {
        //base case
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if(isVisited[row][col] || grid[row][col] == '0') return;

        isVisited[row][col] = true;

        dfs(grid, isVisited, row, col + 1); // right
        dfs(grid, isVisited, row, col - 1); // left
        dfs(grid, isVisited, row - 1, col); // top
        dfs(grid, isVisited, row + 1, col); // bottom
    }
}