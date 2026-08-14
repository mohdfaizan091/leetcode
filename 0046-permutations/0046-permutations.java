class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        computeNoOfPermutation(nums , result , temp);
        return result;
    }

    public void computeNoOfPermutation(int[] nums , List<List<Integer>> result , List<Integer> temp) {
        if(temp.size() == nums.length) {
            // result;
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0 ; i<nums.length ; i++) {
            if(temp.contains(nums[i])) {
                // to check that is no already present in in permutation
                continue;
            }
            temp.add(nums[i]);
            computeNoOfPermutation(nums , result , temp);
            temp.remove(temp.size()-1);
        }
    }
}