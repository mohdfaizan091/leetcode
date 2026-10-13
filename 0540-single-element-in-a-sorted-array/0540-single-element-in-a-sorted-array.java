class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        while(j < n) {
            if(nums[i] == nums[j]) {
                j++;
            } else {
                int length = j - i;
                if(length == 1) return nums[i];
                i = j;
            }
        }
        int length = j - i;
        if(length == 1) return nums[i];
        return 0;
    }
}