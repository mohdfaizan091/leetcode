class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length && nums[i]<0 && k>0) {
            nums[i] *= -1;
            i++;
            k--;
        }
        if(k%2 == 1) {
            Arrays.sort(nums);
            nums[0] *= -1;
        }
        int sum=0;
        for(int j=0 ; j<nums.length ; j++) {
            sum += nums[j];
        }

        return sum;
    }
}