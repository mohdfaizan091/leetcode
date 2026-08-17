class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int total = 1 << n;
        for(int i=0 ; i<total ; i++) {
            int num = i;
            List<Integer> temp = new ArrayList<>();
            for(int bitIdx=0 ; bitIdx<n ; bitIdx++) {
                if(num%2 !=0) {
                    temp.add(nums[bitIdx]);
                }
                num = num >> 1;
            }
            ans.add(temp);
        }
        return ans;
    }
}