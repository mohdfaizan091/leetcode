class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        double ans = 0.0;
        double max = Integer.MIN_VALUE;


        while(j < k) {
            ans += nums[j];
            j++;
        }

        max = Math.max(max , ans / k);

        j = j - 1;
        while(j < n - 1) {
            ans -= nums[i];
            i++;
            j++;
            ans += nums[j];
            max = Math.max(max , ans / k);
        }

        return max;
    }
}