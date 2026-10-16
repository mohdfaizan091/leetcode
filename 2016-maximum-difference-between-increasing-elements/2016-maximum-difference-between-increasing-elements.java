class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int n = nums.length;
        for(int i=0 ; i<n ; i++) {
            int min = nums[i];
            int max = nums[i];
            boolean isFound = false;
            for(int j=i+1 ; j<n ; j++) {
                if(nums[j] > min) {
                    max = Math.max(max , nums[j]);
                    isFound = true;
                }
            }
            if(isFound) {
                int tempAns = max - min;
                ans = Math.max(ans , tempAns);
            }
        }
        return ans;
    }
}