class Solution {
    public int removeDuplicates(int[] nums) {
        //force;
        int[] ans = new int[nums.length];
        int i = 0;
        int k = 0;
        int j = 0;
        int count = 1;
        while(j < nums.length) {
            if(nums[i] == nums[j]) {
                j++;
            } else {
                count++;
                ans[k] = nums[i];
                i = j;
                k++;
            }
        }
        ans[k] = nums[i];
        for(int m=0 ; m<nums.length ; m++) {
            nums[m] = ans[m];
        }
        return count;
    }
}