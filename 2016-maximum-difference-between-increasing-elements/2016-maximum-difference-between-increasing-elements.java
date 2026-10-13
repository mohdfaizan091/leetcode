class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int minVal = nums[0];

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > minVal) {
                maxDiff = Math.max(maxDiff, nums[j] - minVal);
            } else {
                minVal = nums[j]; 
            }
        }

        return maxDiff;
    }
}
