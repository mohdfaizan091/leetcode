class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];
        int max = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }

        if (k >= total) {
            return 0;
        }

        int left = 0;
        int right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long operations = 0;

            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long sum = 0;

        for (int d : diff) {
            int reduced = Math.min(d, left);
            sum += (long) reduced * reduced;
            k -= d - reduced;
        }

        for (int i = 0; i < n && k > 0; i++) {
            if (Math.min(diff[i], left) == left && left > 0) {
                sum -= (long) left * left;
                sum += (long) (left - 1) * (left - 1);
                k--;
            }
        }

        return sum;
    }
}