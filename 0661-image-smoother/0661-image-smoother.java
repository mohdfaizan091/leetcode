class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int avg = 0;
                int count = 0;

                // Current cell
                avg += img[i][j];
                count++;

                // Top
                if (i > 0) {
                    avg += img[i - 1][j];
                    count++;
                }
                // Left
                if (j > 0) {
                    avg += img[i][j - 1];
                    count++;
                }
                // Bottom
                if (i < m - 1) {
                    avg += img[i + 1][j];
                    count++;
                }
                // Right
                if (j < n - 1) {
                    avg += img[i][j + 1];
                    count++;
                }
                // Top-Left diagonal
                if (i > 0 && j > 0) {
                    avg += img[i - 1][j - 1];
                    count++;
                }
                // Top-Right diagonal
                if (i > 0 && j < n - 1) {
                    avg += img[i - 1][j + 1];
                    count++;
                }
                // Bottom-Left diagonal
                if (i < m - 1 && j > 0) {
                    avg += img[i + 1][j - 1];
                    count++;
                }
                // Bottom-Right diagonal
                if (i < m - 1 && j < n - 1) {
                    avg += img[i + 1][j + 1];
                    count++;
                }

                res[i][j] = avg / count;
            }
        }

        return res;
    }
}
