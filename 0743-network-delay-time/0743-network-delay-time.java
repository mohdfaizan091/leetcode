class Solution {

    public int networkDelayTime(int[][] times, int n, int src) {

        int[] minNetworkTime = new int[n + 1];
        Arrays.fill(minNetworkTime, Integer.MAX_VALUE);
        minNetworkTime[src] = 0;
        // belmanford algorithm
        for(int i=1 ; i<=n ; i++) {
            for(int j=0 ; j<times.length ; j++) {
                int u = times[j][0];
                int v = times[j][1];
                int wt = times[j][2];
                if(minNetworkTime[u] == Integer.MAX_VALUE) continue;
                // relaxation
                if(minNetworkTime[u] + wt < minNetworkTime[v]) minNetworkTime[v] = minNetworkTime[u] + wt;
            }
        }
        int max = -1;
        for(int i = 1; i <= n; i++) {
            if(minNetworkTime[i] == Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, minNetworkTime[i]);
        }

        return max;
    }
}