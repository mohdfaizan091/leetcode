class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        backTrack(ans , permutation , nums);
        return ans;
    }

    public void backTrack(List<List<Integer>> ans , List<Integer> permutation , int[] nums) {
        if(permutation.size() == nums.length) {
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0 ; i<nums.length ; i++) {
            if(permutation.contains(nums[i])) {
                continue;
            }

            permutation.add(nums[i]);
            backTrack(ans , permutation , nums);
            permutation.remove(permutation.size()-1);
        }
    }
}