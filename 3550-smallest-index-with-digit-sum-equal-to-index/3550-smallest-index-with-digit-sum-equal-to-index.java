class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i=0 ; i<n ; i++) {
            int x = nums[i];
            if(x <= 9) {
                if(x == i) return i;
            }
            else {
                int sum = 0;
                while(x != 0) {
                    sum += x % 10;
                    x = x / 10;
                }
                if(sum == i) return i;
            }
        }
        return idx;
    }
}