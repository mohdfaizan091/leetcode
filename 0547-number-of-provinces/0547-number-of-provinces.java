class Solution {
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!isVis[i]) {
                checkConnection(isConnected, isVis, i);
                count++;
            }
        }

        return count;
    }

    public void checkConnection(int[][] isConnected, boolean[] isVis, int idx) {
        Queue<Integer> q = new LinkedList<>();

        q.add(idx);
        isVis[idx] = true;

        while(!q.isEmpty()) {
            int top = q.remove();

            int j = 0;

            while(j < isConnected.length) {
                if(!isVis[j] && isConnected[top][j] == 1) {
                    isVis[j] = true;
                    q.add(j);
                }
                j++;
            }
        }
    }
}