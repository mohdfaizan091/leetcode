class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int i = 0;
        while(i < nums.length) {
            if(i  + 1 == nums[i]) {
                i++;
            }
            else if(nums[i] == nums[nums[i] - 1]) {
                i++;
            } else {
                swap(nums , i , nums[i] - 1);
            }
        }

        for(int j=0 ; j<nums.length ; j++) {
            if(j + 1 != nums[j]) {
                list.add(nums[j]);
            }
        }
        return list;
    }
    public void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}