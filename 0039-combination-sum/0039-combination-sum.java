class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        getcombinationSum(candidates, 0, target, curr, ans);
        return ans;
    }
    public void getcombinationSum(int[] nums, int idx, int target, List<Integer> curr, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList(curr));
            return;
        }
        if(idx >= nums.length || target < 0) {
            return;
        }
        //inclusion
        curr.add(nums[idx]);
        getcombinationSum(nums, idx, target - nums[idx], curr, ans);

        //backtracking
        curr.remove(curr.size() - 1);

        //exclusion
        getcombinationSum(nums, idx + 1, target, curr, ans);
    }
}