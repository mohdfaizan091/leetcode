class Solution {

    int[][] arr;
    int[] next;
    Result[][] dp;

    class Result {
        long weight;
        List<Integer> indices;

        Result(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by start, end, original index
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);

            return Integer.compare(a[3], b[3]);
        });

        // Find next non-overlapping interval
        next = new int[n];

        for (int i = 0; i < n; i++) {

            int lo = i + 1;
            int hi = n - 1;
            int ans = n;

            while (lo <= hi) {

                int mid = lo + (hi - lo) / 2;

                if (arr[mid][0] > arr[i][1]) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            next[i] = ans;
        }

        dp = new Result[n + 1][5];

        Result result = recursion(0, 4);

        Collections.sort(result.indices);

        int[] ans = new int[result.indices.size()];

        for (int i = 0; i < result.indices.size(); i++) {
            ans[i] = result.indices.get(i);
        }

        return ans;
    }

    Result recursion(int i, int k) {

        if (i == arr.length || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // Don't take
        Result notTake = recursion(i + 1, k);

        // Take
        Result nextResult = recursion(next[i], k - 1);

        List<Integer> takeIndices = new ArrayList<>(nextResult.indices);
        takeIndices.add(arr[i][3]);

        Result take = new Result(
            arr[i][2] + nextResult.weight,
            takeIndices
        );

        // Choose better result
        if (take.weight > notTake.weight) {

            dp[i][k] = take;

        } else if (take.weight < notTake.weight) {

            dp[i][k] = notTake;

        } else {

            // Same weight → lexicographically smaller indices
            Collections.sort(take.indices);
            Collections.sort(notTake.indices);

            if (isSmaller(take.indices, notTake.indices)) {
                dp[i][k] = take;
            } else {
                dp[i][k] = notTake;
            }
        }

        return dp[i][k];
    }

    boolean isSmaller(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}