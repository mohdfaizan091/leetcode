class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] indegree = new int[n];
        for(int i=0 ; i<n ; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0 ; i<n ; i++) {
            for(int ele : graph[i]) {
                adjList.get(ele).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ; i<n ; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        while(q.size() > 0) {
            int front = q.remove();
            ans.add(front);
            for(int ele : adjList.get(front)) {
                indegree[ele]--;
                if(indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}