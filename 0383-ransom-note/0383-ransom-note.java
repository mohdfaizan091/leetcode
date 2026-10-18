class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character , Integer> map = new HashMap<>();
        int mal = magazine.length();
        int ranl = ransomNote.length();

        for(int i=0 ; i<mal ; i++) {
            char ch = magazine.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch , 1);
            } else {
                int freq = map.get(ch);
                map.put(ch , freq + 1);
            }
        }

        for(int i=0 ; i<ranl ; i++) {
            char ch = ransomNote.charAt(i);
            if(!map.containsKey(ch)) {
                return false;
            } else {
                int freq = map.get(ch);
                if(freq > 1) {
                    map.put(ch , freq - 1);
                } else {
                    map.remove(ch);
                }
            }
        }
        return true;
    }
}