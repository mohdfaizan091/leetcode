class Solution {

    class Triplet implements Comparable<Triplet> {
        int node;
        int parent;
        int dist;

        Triplet(int node, int parent, int dist) {
            this.node = node;
            this.parent = parent;
            this.dist = dist;
        }

        public int compareTo(Triplet t) {
            if (t.dist == this.dist)
                return this.node - t.node;

            return this.dist - t.dist;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        int sum = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        boolean[] isvis = new boolean[n];

        pq.add(new Triplet(0, -1, 0));

        while (pq.size() > 0) {

            Triplet front = pq.remove();

            int node = front.node;
            int parent = front.parent;
            int dist = front.dist;

            if (isvis[node]) continue;

            isvis[node] = true;
            sum += dist;

            for (int i = 0; i < n; i++) {

                if (i == parent) continue;
                if (isvis[i]) continue;
                if (i == node) continue;

                int x1 = points[node][0];
                int y1 = points[node][1];

                int x2 = points[i][0];
                int y2 = points[i][1];

                int dis = Math.abs(x1 - x2)
                         + Math.abs(y1 - y2);

                pq.add(new Triplet(i, node, dis));
            }
        }

        return sum;
    }
}