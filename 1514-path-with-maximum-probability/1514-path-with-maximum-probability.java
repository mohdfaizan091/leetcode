class Solution {
// pair --
    public class pair implements Comparable<pair> {
        int node;
        double prob;

        pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }

        @Override
        public int compareTo(pair p) {
            if (this.prob == p.prob)
                return Integer.compare(this.node, p.node);

            return Double.compare(this.prob, p.prob);
        }
    }
// --

    public double maxProbability(int n, int[][] times, double[] succProb, int src, int end) {
                List<List<pair>> adj = new ArrayList<>();
// create adj list
        for(int i = 0; i <n; i++) {
            adj.add(new ArrayList<pair>());
        }

// fill the pair list
        for(int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            double weight = succProb[i];

            adj.get(u).add(new pair(v, weight));
            adj.get(v).add(new pair(u, weight));
        }
// ans array
        double[] maxProbability = new double[n];
        Arrays.fill(maxProbability, 0);
// starting or source always be '0'
        maxProbability[src] = 1;

// Dijkstra Algorithm ------------------
        PriorityQueue<pair> pq = new PriorityQueue<pair>(Collections.reverseOrder());
        pq.add(new pair(src, 1));
        while(pq.size() > 0) {
            pair front = pq.remove();

            int node = front.node;
            double prob = front.prob;

            for(pair ele : adj.get(node)) {
                double totalProb = ele.prob * prob;

                if(totalProb > maxProbability[ele.node]) {
                    maxProbability[ele.node] = totalProb;
                    pq.add(new pair(ele.node, totalProb));
                }
            }
        }
// ----------------------------------------

// finding network delay time
        return maxProbability[end];
    }
}