class Solution {
    public boolean canFinish(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        List<Integer> order = new ArrayList<>();
        // fill the list with given edge
        makeList(adjacencyList , edges);
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(!dfs(adjacencyList, visited, pathVisited, order, i)) {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean dfs(List<List<Integer>> adjacencyList, boolean[] visited, boolean[] pathVisited, 
        List<Integer> order, int idx) {

        visited[idx] = true;
        pathVisited[idx] = true;

        for(int neighbour : adjacencyList.get(idx)) {
            if(pathVisited[neighbour]) {
                return false; // cycle
            }
            if(!visited[neighbour]) {
                if(!dfs(adjacencyList, visited, pathVisited, order, neighbour)) {
                    return false;
                }
            }
        }
        pathVisited[idx] = false;
        order.add(idx);
        return true;
    }
    public void makeList(List<List<Integer>> adjacencyList , int[][] edges) {
        for(int i=0 ; i<edges.length ; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjacencyList.get(v).add(u);
        }
    }
}