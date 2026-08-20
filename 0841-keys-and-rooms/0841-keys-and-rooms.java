class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        //breeadth first search
        bfs(rooms , visited , 0);
        
        // check if any rooms is unvisited
        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) return false;
        }
        return true;
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