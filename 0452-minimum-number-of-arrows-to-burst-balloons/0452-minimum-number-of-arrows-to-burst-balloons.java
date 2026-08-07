class Solution {
    public int findMinArrowShots(int[][] points) {
        int[][] ans = merge(points);
        return ans.length;
    }

    class intervalsClass {
        int startInterval;
        int endInterval;

        intervalsClass(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        intervalsClass[] inter = new intervalsClass[n];

        for (int i = 0; i < n; i++) {
            inter[i] = new intervalsClass(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(inter,
                (a1, a2) -> Integer.compare(a1.endInterval, a2.endInterval));

        int[][] result = new int[n][2];

        int i = 0;
        int k = 0;

        while (i < n) {

            int start = inter[i].startInterval;
            int end = inter[i].endInterval;

            int j = i + 1;

            while (j < n && end >= inter[j].startInterval) {
                // end = Math.max(end, inter[j].endInterval);
                j++;
            }

            result[k][0] = start;
            result[k][1] = end;
            k++;

            i = j;
        }

        return Arrays.copyOf(result, k);
    }
}