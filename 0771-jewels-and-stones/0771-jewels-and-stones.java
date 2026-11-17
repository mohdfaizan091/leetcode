class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character , Integer> map = new HashMap<>();

        for(char ch : stones.toCharArray()) {
            if(!map.containsKey(ch)) {
                map.put(ch , 1);
            } else {
                int freq = map.get(ch);
                map.put(ch , freq + 1);
            }
        }

        int count = 0;
        for(char ch : jewels.toCharArray()) {
            if(map.containsKey(ch)) {
                count += map.get(ch);
            }
        }
        
        return count;
    }
}