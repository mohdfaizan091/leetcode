class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = 1;
        }

        int max = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    ans[i] = Math.max(ans[i], ans[j] + 1);
                }
            }
            max = Math.max(max, ans[i]);
        }

        return max;
    }
}