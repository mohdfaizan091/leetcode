class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = new int[n];
        for(int i = 0 ; i<n ; i++) {
            nums[i] = i + 1;
        }
        List<Integer> comb = new ArrayList<>();
        backTrack(ans , comb , nums , 0 , k);
        return ans;
    }
    public void backTrack(List<List<Integer>> ans , List<Integer> comb , int[] nums , int idx , int k) {
        if(comb.size() == k) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        for(int i = idx ; i<nums.length ; i++) {
            comb.add(nums[i]);
            backTrack(ans , comb , nums , i + 1 , k);
            comb.remove(comb.size()-1);
        }
    }
}