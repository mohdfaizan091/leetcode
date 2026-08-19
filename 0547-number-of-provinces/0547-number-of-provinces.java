class Solution {
    public static int findCircleNum(int[][] adj) {
        boolean[] isVisited = new boolean[adj.length];
        int count = 0;

        for (int i = 0; i < adj.length; i++) {
            if (!isVisited[i]) {
                bfs(adj, isVisited, i);
                count++;
            }
        }
        return count;
    }

    public static void bfs(int[][] adj, boolean[] isVisited, int row) {
        Queue<Integer> q = new LinkedList<>();

        q.add(row);
        isVisited[row] = true;

        while (q.size() != 0) {
            int temp = q.poll();
            int j = 0;

            while (j < adj.length) {
                if (adj[temp][j] == 1 && !isVisited[j]) {
                    q.add(j);
                    isVisited[j] = true;
                }
                j++;
            }
        }
    }
}