class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> ans = new ArrayList<>();

        int len1 = nums1.length;
        int len2 = nums2.length;

        List<Integer> list1 = new ArrayList<>();
        for(int i=0 ; i<len1 ; i++) {
            int ele = nums1[i];
            boolean isUnique = true;
            for(int j=0 ; j<len2; j++) {
                if(ele == nums2[j]) {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) {
                if(!list1.contains(ele)) {
                    list1.add(ele);
                }
            }
        }

        ans.add(new ArrayList<>(list1));

        List<Integer> list2 = new ArrayList<>();
        for(int i=0 ; i<len2 ; i++) {
            int ele = nums2[i];
            boolean isUnique = true;
            for(int j=0 ; j<len1; j++) {
                if(ele == nums1[j]) {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) {
                if(!list2.contains(ele)) {
                    list2.add(ele);
                }
            }
        }
        ans.add(new ArrayList<>(list2));

        return ans;
    }
}