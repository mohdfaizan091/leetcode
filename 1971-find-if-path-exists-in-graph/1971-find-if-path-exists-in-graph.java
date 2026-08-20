class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end) return true;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            list.add(new ArrayList<>());
        }
        // create adjacency list
        for(int i=0 ; i<edges.length ; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        boolean[] isVis = new boolean[n];
        bfs(list , isVis , start);
        return isVis[end];
    }
    public void bfs(List<List<Integer>> rooms , boolean[] visited , int key) {
        Queue<Integer> q = new LinkedList<>();

        q.add(key);
        visited[key] = true;

        while (!q.isEmpty()) { 
        int currentRoom = q.remove(); 
            for (int neighbor : rooms.get(currentRoom)) { 
                if (!visited[neighbor]) { 
                    q.add(neighbor); 
                    visited[neighbor] = true; 
                } 
            } 
        }
    }
}