class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int ele : nums) {
            if(map.containsKey(ele)) {
                int freq = map.get(ele);
                map.put(ele , freq + 1);
            } else {
                map.put(ele , 1);
            }
        }
        int ans = -1;
        int freq = 0;
        for(int key : map.keySet()) {
            int value = map.get(key);
            if(value > freq) {
                freq = value;
                ans = key;
            }
        }
        return ans;
    }
}