class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] left = lengthOfLIS(nums);

        reverse(nums);
        int[] right = lengthOfLIS(nums);
        reverse(right);
        reverse(nums);

        int maxMountain = 0;

        for (int i = 1; i < n - 1; i++) {
            if (left[i] > 1 && right[i] > 1) {
                maxMountain = Math.max(maxMountain, left[i] + right[i] - 1);
            }
        }

        return n - maxMountain;
    }

    public int[] lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp;
    }

    public void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }
}