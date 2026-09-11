class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        while(j < nums.length) {
            if(nums[i] != 0 && nums[j] != 0) {
                i++;
                j++;
            } else if(nums[i] == 0 && nums[j] ==0) {
                j++;
            } else if(nums[i] == 0 && nums[j] !=0) {
                swap(i , j , nums);
                i++;
                j++;
            }
        }
    }
    public void swap(int i , int j , int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}