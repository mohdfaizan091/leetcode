class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        backTrack(result , perm , nums);
        return result;
    }
    public void backTrack(List<List<Integer>> result , List<Integer> perm , int[] nums) {
        if(perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }
        for(int i = 0 ; i<nums.length ; i++) {
            if(perm.contains(nums[i])) {
                continue;
            }
            perm.add(nums[i]);
            backTrack(result , perm , nums);
            perm.remove(perm.size()-1);
        }
    }
}