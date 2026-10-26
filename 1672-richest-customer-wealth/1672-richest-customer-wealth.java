class Solution {
    public int maximumWealth(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        int maxWealth = Integer.MIN_VALUE;

        for(int i=0 ; i<row ; i++) {
            int colSum = 0;
            for(int j=0 ; j<col ; j++) {
                colSum += grid[i][j];
            }
            maxWealth = Math.max(maxWealth , colSum);
        }
        return maxWealth;
    }
}