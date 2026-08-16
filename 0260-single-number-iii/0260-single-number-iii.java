class Solution {
    public int[] singleNumber(int[] nums) {
        int result[] = new int[2];
        return singleNo1(nums , result);
    }
    public int[] singleNo1(int[] nums , int[] result) {
        int k=0;
        for(int i=0 ; i<nums.length ; i++) {
            boolean flag = false;
            for(int j=0 ; j<nums.length ; j++) {
                if(i != j && nums[i] == nums[j]) {
                    flag = true;
                }
            }
            if(flag == false) {
                result[k] = nums[i];
                k++;
            }
        }
        return result;
    }
}