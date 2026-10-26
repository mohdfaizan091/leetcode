class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> ans = new ArrayList<>();
        
        HashSet<Integer> set1 = new HashSet<>();
        for(int i=0 ; i<nums2.length ; i++) {
            set1.add(nums2[i]);
        }

        List<Integer> list1 = new ArrayList<>();

        for(int ele : nums1) {
            if(!set1.contains(ele)) {
                if(!list1.contains(ele)) list1.add(ele);
            }
        }

        ans.add(new ArrayList<>(list1));

        HashSet<Integer> set2 = new HashSet<>();
        for(int i=0 ; i<nums1.length ; i++) {
            set2.add(nums1[i]);
        }

        List<Integer> list2 = new ArrayList<>();

        for(int ele : nums2) {
            if(!set2.contains(ele)) {
                if(!list2.contains(ele)) list2.add(ele);
            }
        }

        ans.add(new ArrayList<>(list2));

        return ans;

    }
}