
class Solution {
    public int[] sortArray(int[] nums) {
        applyMergeSort(nums);
        return nums;
    }

    public void applyMergeSort(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }

        int m1 = n / 2;
        int m2 = n - m1;

        int[] arr1 = new int[m1];
        makeDeepCopy(nums, 0, arr1);

        int[] arr2 = new int[m2];
        makeDeepCopy(nums, m1, arr2);

        applyMergeSort(arr1);
        applyMergeSort(arr2);
        mergeTwoSortedArray(arr1, arr2, nums);
    }

    public void makeDeepCopy(int[] nums, int start, int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = nums[start + i];
        }
    }

    public void mergeTwoSortedArray(int[] arr1, int[] arr2, int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                nums[k] = arr1[i];
                i++;
                k++;
            } else {
                nums[k] = arr2[j];
                j++;
                k++;
            }
        }

        while(i < arr1.length) {
            nums[k] = arr1[i];
            i++;
            k++;
        }

        while(j < arr2.length) {
            nums[k] = arr2[j];
            j++;
            k++;
        }
    }
}
