class Solution {
    public boolean canFinish(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        List<Integer> order = new ArrayList<>();
        makeList(adjacencyList , edges);


        // kahn's algorithm--------------------------------------------------------

        // Queue<Integer> q = new LinkedList<>();
        // for(int i=0 ; i<n ; i++) {
        //     if(indegree[i] == 0) {
        //         q.add(i);
        //     }
        // }
        // while(q.size() > 0) {
        //     int front = q.remove();
        //     for(int ele : adjacencyList.get(front)) {
        //         indegree[ele]--;
        //         if(indegree[ele] == 0) {
        //             q.add(ele);
        //         }
        //     }
        //     order.add(front);
        // }
        // return (n == order.size());      

// --------------------------------------------------------------------------------------


        // dfs

        boolean[] isvis = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i=0 ; i<n ; i++) {
            if(!isvis[i]) {
                if(dfs(adjacencyList, isvis, path, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adjList , boolean[] isvis , boolean[] path , int idx) {
        isvis[idx] = true;
        path[idx] = true;
        for(int ele : adjList.get(idx)) {
            if(!isvis[ele]) {
                if(dfs(adjList, isvis, path, ele)) {
                    return true;
                }
            }
            else if(path[ele]) return true;
        }
        path[idx] = false;
        return false;
    }

    // ----------------------

    public void makeList(List<List<Integer>> adjacencyList , int[][] edges) {
        for(int i=0 ; i<edges.length ; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjacencyList.get(v).add(u);
        }
    }
}