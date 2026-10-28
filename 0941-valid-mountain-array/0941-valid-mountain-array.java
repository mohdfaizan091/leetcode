class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        int n = arr.length;

        if(n < 3) return false;

        while(i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == n - 1) {
            return false;
        }

        for(int j=i ; j<n - 1 ; j++) {
            if(arr[j] <= arr[j + 1]) return false;
        }

        return true;
    }
}