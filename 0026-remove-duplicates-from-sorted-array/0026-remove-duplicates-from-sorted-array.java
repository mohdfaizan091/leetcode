class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j =0;
        int n = nums.length;
        int k=0;
        int count = 1;
        while(i<n && j<n) {
            if(nums[i] == nums[j]) {
                j++;
            }
            else {
                nums[k] = nums[i];
                k++;
                i = j;
                count++;
            }
        }
        nums[k] = nums[i];
        return count;
    }
}