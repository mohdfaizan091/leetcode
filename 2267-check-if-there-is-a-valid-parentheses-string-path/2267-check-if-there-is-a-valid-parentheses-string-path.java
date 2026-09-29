class Solution {
    private Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new Boolean[m][n][(m + n) / 2 + 1];
        return checkValid(0, 0, grid, 0);
    }

    public boolean checkValid(int row, int col, char[][] grid, int count) {
        int m = grid.length;
        int n = grid[0].length;

        if (row >= m || col >= n) {
            return false;
        }

        if (grid[row][col] == '(') {
            count += 1;
        } else {
            count -= 1;
        }

        if (count < 0 || count > (m + n) / 2) {
            return false;
        }

        if (row == m - 1 && col == n - 1) {
            return count == 0;
        }

        if (memo[row][col][count] != null) {
            return memo[row][col][count];
        }

        boolean down = checkValid(row + 1, col, grid, count);
        boolean right = checkValid(row, col + 1, grid, count);

        return memo[row][col][count] = down || right;
    }
}