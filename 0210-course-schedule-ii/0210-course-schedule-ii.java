class Solution {
    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        List<Integer> order = new ArrayList<>();
        int[] indegree = new int[n];
        makeList(adjacencyList , edges , indegree);
        // kahn's algorithm
        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ; i<n ; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        while(q.size() > 0) {
            int front = q.remove();
            for(int ele : adjacencyList.get(front)) {
                indegree[ele]--;
                if(indegree[ele] == 0) {
                    q.add(ele);
                }
            }
            order.add(front);
        }
        if(order.size() != n) return new int[0];
        int[] ans = new int[order.size()];
        for(int i=0 ; i<order.size() ; i++) {
            ans[i] = order.get(i);
        }
        return ans;
    }
    public void makeList(List<List<Integer>> adjacencyList , int[][] edges , int[] indegree) {
        for(int i=0 ; i<edges.length ; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjacencyList.get(v).add(u);
            indegree[u]++;
        }
    }
}