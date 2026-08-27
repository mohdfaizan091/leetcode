class Solution {
// pair --
    public class pair implements Comparable<pair> {
        int node;
        int time;

        pair(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(pair p) {
            if(this.time == p.time) return this.node - p.node;
            return this.time - p.time;
        }
    }
// --
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<pair>> adj = new ArrayList<>();
// create adj list
        for(int i = 0; i <=n; i++) {
            adj.add(new ArrayList<pair>());
        }

// fill the pair list
        for(int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int weight = times[i][2];

            adj.get(u).add(new pair(v, weight));
        }
// ans array
        int[] minNetworkTime = new int[n + 1];
        Arrays.fill(minNetworkTime, Integer.MAX_VALUE);
// starting or source always be '0'
        minNetworkTime[src] = 0;

// Dijkstra Algorithm ------------------
        PriorityQueue<pair> pq = new PriorityQueue<pair>();
        pq.add(new pair(src, 0));
        while(pq.size() > 0) {
            pair front = pq.remove();

            int node = front.node;
            int time = front.time;

            for(pair ele : adj.get(node)) {
                int totalTime = ele.time + time;

                if(totalTime < minNetworkTime[ele.node]) {
                    minNetworkTime[ele.node] = totalTime;
                    pq.add(new pair(ele.node, totalTime));
                }
            }
        }
// ----------------------------------------

// finding network delay time
        int max = -1;
        for(int i = 1; i <= n; i++) {
            if(minNetworkTime[i] == Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, minNetworkTime[i]);
        }

        return max;
    }
}