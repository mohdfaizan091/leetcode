class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        return maximumSum(nums , k);
    }
    public int maximumSum(int[] arr , int k) {
        // if value in array is negative
        int i = 0;
        Arrays.sort(arr);
        while( i < arr.length && arr[i] < 0 && k > 0) {
            arr[i]*= -1;
            i++;
            k--;
        }

        // if k!=0
        if(k % 2 == 1) {
            Arrays.sort(arr);
            arr[0]*= -1;
        }

        int sum = 0;
        for(int j=0 ; j<arr.length ; j++) {
            sum+= arr[j];
        }

        return sum;
    }
}