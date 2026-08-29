class Solution {
    class Triplet implements Comparable<Triplet> {
        int row;
        int col;
        int effort;
        Triplet(int row , int col , int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
        public int compareTo(Triplet t) {
            if(this.effort == t.effort) return this.row - t.row;
            return this.effort - t.effort;
        }
    }
    public int minimumEffortPath(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] minEffort = new int[m][n];
        for(int i=0; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                minEffort[i][j] = Integer.MAX_VALUE;
            }
        }
        minEffort[0][0] = 0;
        int[] r = {-1 , 0 , 1 , 0};
        int[] c = {0 , 1 , 0 , -1};
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0 , 0 , 0));

        while(pq.size() > 0) {
            Triplet top = pq.remove();
            int row = top.row;
            int col = top.col;
            if(row == m-1 && col == n-1) break;
            int effort = top.effort;
            for(int i=0 ; i<=3 ; i++) {
                int nr = row + r[i];
                int nc = col + c[i];
                if(nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    continue;
                }
                int e = Math.abs(arr[row][col] - arr[nr][nc]);
                e = Math.max(e , minEffort[row][col]);
                if(e < minEffort[nr][nc]) {
                    minEffort[nr][nc] = e;
                    pq.add(new Triplet(nr , nc  , e));
                }
            }
            // // up row - 1
            // if(row > 0) {
            //     int e = Math.abs(arr[row][col] - arr[row - 1][col]);
            //     e = Math.max(e , minEffort[row][col]);
            //     if(e < minEffort[row -1 ][col]) {
            //         minEffort[row -1 ][col] = e;
            //         pq.add(new Triplet(row - 1 , col , e));
            //     }
            // }
            // // right col + 1
            // if(col <  n -1) {
            //     int e = Math.abs(arr[row][col] - arr[row][col + 1]);
            //     e = Math.max(e , minEffort[row][col]);
            //     if(e < minEffort[row][col + 1]) {
            //         minEffort[row][col + 1] = e;
            //         pq.add(new Triplet(row , col + 1 , e));
            //     }
            // }
            // // bottom row + 1
            // if(row <  m - 1) {
            //     int e = Math.abs(arr[row][col] - arr[row + 1][col]);
            //     e = Math.max(e , minEffort[row][col]);
            //     if(e < minEffort[row + 1 ][col]) {
            //         minEffort[row + 1 ][col] = e;
            //         pq.add(new Triplet(row + 1 , col , e));
            //     }
            // }
            // // left col - 1
            // if(col >  0) {
            //     int e = Math.abs(arr[row][col] - arr[row][col - 1]);
            //     e = Math.max(e , minEffort[row][col]);
            //     if(e < minEffort[row][col - 1]) {
            //         minEffort[row][col - 1] = e;
            //         pq.add(new Triplet(row , col - 1 , e));
            //     }
            // }
        }
        return minEffort[m-1][n-1];
    }
}