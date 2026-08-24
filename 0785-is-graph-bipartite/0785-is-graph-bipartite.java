class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int[] coloring = new int[n];
        
        // mark color to uncolor
        for(int i = 0; i < n; i++) {
            coloring[i] = -1;
        }
        
        for(int i = 0; i < n; i++) {
            if(coloring[i] == -1) {
                if(!bfs(graph, coloring, i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean bfs(int[][] graph, int[] coloring, int idx) {
        // 0 - red
        // 1 - blue
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(idx);
        coloring[idx] = 0;
        
        while(q.size() > 0) {
            int neighbour = q.remove();
            
            for(int i = 0; i < graph[neighbour].length; i++) {
                
                int node = graph[neighbour][i];
                
                if(coloring[node] == -1) {
                    
                    // mark opposite color of adjacent node
                    if(coloring[neighbour] == 0) {
                        coloring[node] = 1;
                    } else {
                        coloring[node] = 0;
                    }
                    
                    q.add(node);
                }
                
                else if(coloring[node] == coloring[neighbour]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}