class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0 ; i<n ; i++) {
            int m = nums[i];
            int count = 0;
            while(m != 0) {
                m = m/10;
                count++;
            }
            if(count % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}