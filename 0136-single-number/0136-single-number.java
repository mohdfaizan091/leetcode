class Solution {
    public int singleNumber(int[] nums) {
        return findSingleNo2(nums);
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

    //approach 2 : Sorting
    public int findSingleNo2(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-2) {
            if(nums[i] != nums[i+1]) {
                return nums[i];
            }
            i = i + 2;
        }
        return nums[i];
    }
}