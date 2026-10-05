class Solution {
    public void countFreq(String p, HashMap<Character, Integer> map) {
        int n = p.length();
        for (int i = 0; i < n; i++) {
            char ch = p.charAt(i);
            if (map.containsKey(ch)) {
                int freq = map.get(ch);
                map.put(ch, freq + 1);
            } else {
                map.put(ch, 1);
            }
        }
    }
    public boolean checkInclusion(String s1, String s2) {
        int m = s2.length();
        int n = s1.length();

        if(m < n) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        countFreq(s1, map);

        int i = 0;
        int j = 0;

        int[] characterArray = new int[26];
        while(j < n) {
            char ch = s2.charAt(j);
            int idx = ch - 'a';
            characterArray[idx]++;
            j++;
        }

        while (j <= m) {
            if (isValidAnagaramViaFreqCount(characterArray , map)) {
                return true;
            }
            char ch1 = s2.charAt(i);
            int idx1 = ch1 - 'a';
            characterArray[idx1]--;

            if(j < m) {
                char ch2 = s2.charAt(j);
                int idx2 = ch2 - 'a';
                characterArray[idx2]++;
            }

            i++;
            j++;
        }
        return false;
    }
    public boolean isValidAnagaramViaFreqCount(int[] characterArray, HashMap<Character, Integer> map) {
        
        for (char ch : map.keySet()) {
            int idx = ch - 'a';
            if (characterArray[idx] != map.get(ch)) {
                return false;
            }
        }
        return true;
    }
}