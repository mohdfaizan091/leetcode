class Solution {
    static int[] parent;
    static int[] ans;
    public void union(int a , int b) {
        int leaderA = find(a);
        int leaderB = find(b);
        if(leaderA == leaderB) {
            ans[0] = a;
            ans[1] = b;
        }
        if(leaderA != leaderB) {
            parent[leaderA] = leaderB;
        }
    }
    public int find(int a) {
        if(parent[a] == a) return a;
        return find(parent[a]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        ans = new int[2];
        for(int i=1 ; i<=n ; i++) {
            parent[i] = i;
        }
        for (int i=0 ; i<n ; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            union(u , v);
        }
        return ans;
    }
}