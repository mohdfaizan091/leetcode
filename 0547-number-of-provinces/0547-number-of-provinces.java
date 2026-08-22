class Solution {
    public int findCircleNum(int[][] adjMatrix) {
        int bfs = breadthFirstSearch(adjMatrix);
        return bfs; 
    }
    public int breadthFirstSearch(int[][] adjMatrix) {
        int n = adjMatrix.length;
        int count = 0;
        boolean[] isVisited = new boolean[n];
        for(int i=0 ; i<n ; i++) {
            if(!isVisited[i]) {
                bfs(isVisited , adjMatrix , i);
                count++;
            }
        }
        return count;
    }
    public void bfs(boolean[] isVisited , int[][] adjMatrix , int row) {
        Queue<Integer> q = new LinkedList<>();
        isVisited[row] = true;
        q.add(row);
        while(q.size() > 0) {
            int i = q.remove();
            for(int j=0 ; j<adjMatrix.length ; j++) {
                if(adjMatrix[i][j] == 1 && !isVisited[j]) {
                    isVisited[j] = true;
                    q.add(j);
                }
            }
        }
    }
}