class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];
        for(int i=0 ; i<n ; i++) {
            int nge = -1;
            int ele = nums1[i];
            int j=0;
            while(ele != nums2[j]) {
                j++;
            }
            for(int k = j+1 ; k<m ; k++) {
                if(nums2[k] > ele) {
                    nge = nums2[k];
                    break;
                }
            }
            ans[i] = nge;
        }
        return ans;
    }
}