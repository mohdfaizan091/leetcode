class Solution {
    public int findLongestChain(int[][] pairs) {
        return pair(pairs);
    }

    class intervalsClass {
        int startInterval;
        int endInterval;

        intervalsClass(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    public int pair(int[][] intervals) {

        int n = intervals.length;
        if (n == 0) return 0;

        intervalsClass[] inter = new intervalsClass[n];

        for (int i = 0; i < n; i++) {
            inter[i] = new intervalsClass(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(inter, (a1, a2) -> Integer.compare(a1.endInterval, a2.endInterval));

        int countPairs = 1;
        int i = 0;

        for (int j = 1; j < n; j++) {
            if (inter[j].startInterval > inter[i].endInterval) {
                countPairs++;
                i = j;
            }
        }

        return countPairs;
    }
}