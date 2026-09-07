class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {

        int[][] edgeMatrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                edgeMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            edgeMatrix[u][v] = wt;
            edgeMatrix[v][u] = wt;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {

                    if(edgeMatrix[i][k] != Integer.MAX_VALUE &&
                       edgeMatrix[k][j] != Integer.MAX_VALUE) {

                        edgeMatrix[i][j] = Math.min(
                            edgeMatrix[i][j],
                            edgeMatrix[i][k] + edgeMatrix[k][j]
                        );
                    }
                }
            }
        }
        int minCity = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(i != j && edgeMatrix[i][j] <= threshold) {
                    count++;
                }
            }
            if(count <= minCity) {
                minCity = count;
                idx = i;
            }
        }
        return idx;
    }
}