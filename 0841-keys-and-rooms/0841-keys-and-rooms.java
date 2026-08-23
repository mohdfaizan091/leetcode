class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return canVisitAllRoom(rooms);
    }
    
    public boolean canVisitAllRoom(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(rooms , visited , 0);
        // bfs(rooms , visited , 0);
        
        // check if any rooms is unvisited
        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) return false;
        }
        return true;
    } 
    

    // dfs
    public void dfs(List<List<Integer>> rooms , boolean[] visited , int idx) {
        visited[idx] = true;
        List<Integer> list = rooms.get(idx);
        for(int i=0 ; i<list.size() ; i++) {
            if(!visited[list.get(i)]) {
                dfs(rooms , visited , list.get(i));
            }
        }
    }


    // bfs
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