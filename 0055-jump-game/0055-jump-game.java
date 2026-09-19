class Solution {

    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return isJump(0, nums, dp);
    }

    public boolean isJump(int jump, int[] nums, int[] dp) {

        if(jump >= nums.length - 1) return true;
        if(nums[jump] == 0) return false;
        if(dp[jump] != -1) {
            return dp[jump] == 1;
        }
        int n = nums[jump];
        for(int i = 1; i <= n; i++) {
            int nextJump = jump + i;
            if(isJump(nextJump, nums, dp)) {
                dp[jump] = 1;
                return true;
            }
        }
        dp[jump] = 0;
        return false;
    }
}