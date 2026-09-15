class Solution {
    class triplet{
        int row;
        int col;
        triplet(int row , int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image;

        int m = image.length;
        int n = image[0].length;
        boolean[][] isvis = new boolean[m][n];
        Queue<triplet> q = new LinkedList<>();
        q.add(new triplet(sr , sc));
        
        while(q.size() > 0) {
            triplet top = q.remove();
            int r = top.row;
            int c = top.col;
            isvis[r][c] = true;
            int currColor = image[r][c];
            image[r][c] = color;

            if(r+1 < m) {
                if(image[r+1][c] == currColor && !isvis[r+1][c]) {
                    q.add(new triplet(r+1 , c));
                }
            }
            if(r-1 >= 0) {
                if(image[r-1][c] == currColor && !isvis[r-1][c]) {
                    q.add(new triplet(r-1 , c));
                }
            }
            if(c+1 < n) {
                if(image[r][c+1] == currColor && !isvis[r][c+1]) {
                    q.add(new triplet(r , c+1));
                }
            }
            if(c-1 >= 0) {
                if(image[r][c-1] == currColor && !isvis[r][c-1]) {
                    q.add(new triplet(r , c-1));
                }
            }
        }
        return image;
    }
}