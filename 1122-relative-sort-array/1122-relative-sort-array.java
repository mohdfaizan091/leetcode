import java.util.Arrays;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[] ans = new int[l1];
        int k = 0;
        
        boolean[] visited = new boolean[l1];

        for(int i = 0; i < l2; i++) {
            int ele = arr2[i];
            for(int j = 0; j < l1; j++) {
                if(ele == arr1[j]) {
                    ans[k] = ele;
                    k++;
                    visited[j] = true; 
                }
            }
        }

        int startOfRemaining = k; 
        for(int j = 0; j < l1; j++) {
            if(!visited[j]) {
                ans[k] = arr1[j];
                k++;
            }
        }

        Arrays.sort(ans, startOfRemaining, l1);

        return ans;
    }
}
