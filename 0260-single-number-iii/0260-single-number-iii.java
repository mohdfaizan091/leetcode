class Solution {
    public int[] singleNumber(int[] nums) {
        int result[] = new int[2];
        return singleNo2(nums , result);
    }
    // brute-force approach  TC = O(n^2)
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
    // approach 02  : TC = O(n)
    public int[] singleNo2(int[] nums , int[] ans) {
        int xor = 0;
        for(int ele : nums) {
            xor ^= ele;
        }
        int mask = xor & xor - 1;
        mask = mask ^ xor;
        int b1 = 0 , b2 = 0;
        for(int ele : nums) {
            if((ele & mask) == 0) {
                b1 ^= ele;
            } else {
                b2 ^= ele;
            }
        }
        ans[0] = b1;
        ans[1] = b2;
        return ans;
    }
    
}