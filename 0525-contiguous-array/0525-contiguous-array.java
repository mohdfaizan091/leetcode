class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> Map = new HashMap<>();
        Map.put(0, -1);          

        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1) ? 1 : -1;   

            if (Map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - Map.get(sum));
            } else {
                Map.put(sum, i);      
            }
        }
        return maxLen;
    }
}