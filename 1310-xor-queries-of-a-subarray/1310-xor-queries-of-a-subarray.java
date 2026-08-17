class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] ans = new int[queries.length];
        // prefix-xor
        for(int i=1 ; i<n ; i++) {
            arr[i] = arr[i - 1] ^ arr[i];
        }

        for(int i=0; i<queries.length ; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if(left == 0) ans[i] = arr[right];
            else ans[i] = arr[left - 1] ^ arr[right];
        }

        return ans;
    }
}