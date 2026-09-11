class Solution {

    class pair {
        int row;
        int col;
        int time;
        pair(int row , int col , int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isvis = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        int fresh = 0;
        boolean flag = false;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(grid[i][j] == 2) {
                    q.add(new pair(i , j , 0));
                    isvis[i][j] = true;
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] != 0) {
                    flag = true;
                }
            }
        }
        int ans = -1;
        while(q.size() > 0) {
            pair p = q.remove();
            int r = p.row;
            int c = p.col;
            int t = p.time;
            ans = Math.max(ans , t);
            if(r-1 >= 0 && !isvis[r-1][c] && grid[r-1][c] == 1) {
                q.add(new pair(r-1 , c , t + 1));
                isvis[r-1][c] = true;
                fresh--;
            }
            if(c+1 < m && !isvis[r][c+1] && grid[r][c+1] == 1) {
                q.add(new pair(r , c+1 , t + 1));
                isvis[r][c+1] = true;
                fresh--;
            }
            if(r+1 < n && !isvis[r+1][c] && grid[r+1][c] == 1) {
                q.add(new pair(r+1 , c , t + 1));
                isvis[r+1][c] = true;
                fresh--;
            }
            if(c-1 >= 0 && !isvis[r][c-1] && grid[r][c-1] == 1) {
                q.add(new pair(r , c-1 , t + 1));
                isvis[r][c-1] = true;
                fresh--;
            }
        }
        if(flag == false) return 0;
        return fresh == 0 ? ans : -1;
    }
}