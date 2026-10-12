class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        HashSet<Integer> set  =new HashSet<>();
        for(int i=0 ; i<n ; i++) {
            int ele = nums1[i];
            for(int j=0 ; j<m ; j++) {
                if(ele == nums2[j]) {
                    set.add(ele);
                }
            }
        }
        int size = set.size();
        int[] ans = new int[size];
        int k = 0;
        for(int ele : set) {
            ans[k] = ele;
            k++;
        }
        return ans;
    }
}