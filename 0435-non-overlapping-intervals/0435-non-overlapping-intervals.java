class Solution {
    //space optimized - than previous
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = merge(intervals);
        return ans;
    }

    class intervalsClass {
        int startInterval;
        int endInterval;

        intervalsClass(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    public int merge(int[][] intervals) {

        int n = intervals.length;
        int noOfOverlapingInterval = 0;

        intervalsClass[] inter = new intervalsClass[n];

        for (int i = 0; i < n; i++) {
            inter[i] = new intervalsClass(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(inter,
                (a1, a2) -> Integer.compare(a1.startInterval, a2.startInterval));

        int i = 0;
        while (i < n) {

            int start = inter[i].startInterval;
            int end = inter[i].endInterval;

            int j = i + 1;

            while (j < n && end > inter[j].startInterval) {
                end = Math.min(end, inter[j].endInterval);
                noOfOverlapingInterval++;
                j++;
            }
            i = j;
        }

        return noOfOverlapingInterval;
    }
}