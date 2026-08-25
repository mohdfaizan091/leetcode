class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] isColored = new int[n];
        
        // mark color to uncolor
        for(int i = 0; i < n; i++) {
            isColored[i] = -1;
        }
        
        for(int i = 0; i < n; i++) {
            if(isColored[i] == -1) {
                if(!bfs(graph, isColored, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean bfs(int[][] graph, int[] isColored, int idx) {
        // 0 - red
        // 1 - blue
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(idx);
        isColored[idx] = 0;
        
        while(q.size() > 0) {
            int neighbour = q.remove();
            for(int i = 0; i < graph[neighbour].length; i++) {
                int node = graph[neighbour][i];
                // unvisted
                if(isColored[node] == -1) {
                    // mark opposite color of adjacent node
                    if(isColored[neighbour] == 0) {
                        isColored[node] = 1;
                    } 
                    else {
                        isColored[node] = 0;
                    }
                    q.add(node);
                }
                //visited and has already same color-means cycle having odd no node
                else if(isColored[node] == isColored[neighbour]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}