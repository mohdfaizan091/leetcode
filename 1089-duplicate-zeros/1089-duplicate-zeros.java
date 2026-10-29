class Solution {
    public void duplicateZeros(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int count = 0;

        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i] == 0) {
                ans.add(0);
                ans.add(0);
                count++;
            } else {
                ans.add(arr[i]);
            }
        }

        for(int i=0 ; i<ans.size() - count ; i++) {
            arr[i] = ans.get(i);
        }
    }
}