class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        
        int min = Integer.MAX_VALUE;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        
        return res;
    }
}
