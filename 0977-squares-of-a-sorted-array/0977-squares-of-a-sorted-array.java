class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;

        int[] ans = new int[n];

        for(int i=0 ; i<n ; i++) {
            int sq = nums[i] * nums[i];
            ans[i] = sq;
        }

        Arrays.sort(ans);
        return ans;
    }
}