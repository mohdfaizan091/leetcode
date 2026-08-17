class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int total = 1 << n;
        for(int i=0 ; i<total ; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int bitIdx=0 ; bitIdx<n ; bitIdx++) {
                // (1 << bitIdx) =: to check the perticular bit is set or not set
                int mask = (1 << bitIdx);
                // if set : 
                if((mask & i) != 0) temp.add(nums[bitIdx]);
            }
            ans.add(temp);
        }
        return ans;
    }
}