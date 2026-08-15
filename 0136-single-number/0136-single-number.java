class Solution {
    public int singleNumber(int[] nums) {
        return findSingleNo(nums);
    }

    //approach 1 : bruteforce
    public int findSingleNo(int[] nums) {
        for(int i=0 ; i<nums.length ; i++) {
            boolean flag = true;
            for(int j=0 ; j<nums.length ; j++) {
                if(i != j && nums[i] == nums[j]) {
                    flag = false;
                }
            }
            if(flag == true) return nums[i];
        }
        return 0;
    }
}