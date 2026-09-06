class Solution {

    class pair {
        int node;
        int cost;
        pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    class Triple implements Comparable<Triple> {
        int node;
        int wt;
        int stops;
        Triple(int node, int wt, int stops) {
            this.node = node;
            this.wt = wt;
            this.stops = stops;
        }
        public int compareTo(Triple t) {
            if( this.stops == t.stops) return  this.node - t.node;
            return this.stops - t.stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights,int src, int dst, int k) {

        List<List<pair>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int wt = flights[i][2];
            adjList.get(from).add(new pair(to, wt));
        }

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        ans[src] = 0;

        PriorityQueue<Triple> pq = new PriorityQueue<>();

        pq.add(new Triple(src, 0, 0));

        while(!pq.isEmpty()) {

            Triple front = pq.remove();

            int node = front.node;
            int cost = front.wt;
            int stops = front.stops;

            if(node == dst) {
                continue;
            }

            if(stops > k) {
                continue;
            }

            for(pair p : adjList.get(node)) {

                int totalCost = cost + p.cost;
                if(totalCost < ans[p.node]) {
                    ans[p.node] = totalCost;
                    pq.add(new Triple(p.node,totalCost,stops + 1));
                }
            }
        }

        return ans[dst] == Integer.MAX_VALUE ? -1 : ans[dst];
    }
}