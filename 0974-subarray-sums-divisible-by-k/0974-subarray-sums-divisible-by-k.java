class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        HashMap<Integer , Integer> Map = new HashMap<>();
        Map.put(0 , 1);
        int sum = 0;
        for(int num : nums) {
            sum += num;
            int rem = sum % k;
            if(rem < 0) {
                rem += k;
            }
            if(Map.containsKey(rem)) {
                int freq = Map.get(rem);
                Map.put(rem , freq + 1);
                count += freq;
            } else {
                Map.put(rem , 1);
            }
        }
        return count;
    }
}