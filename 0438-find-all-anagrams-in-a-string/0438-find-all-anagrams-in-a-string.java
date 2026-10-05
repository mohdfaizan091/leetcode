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

    public List<Integer> findAnagrams(String s, String p) {

        int m = s.length();
        int n = p.length();

        HashMap<Character, Integer> map = new HashMap<>();
        countFreq(p, map);

        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = n;

        while (j <= m) {
            if (isValidAnagaramViaFreqCount(s.substring(i, j), map)) {
                ans.add(i);
            }
            i++;
            j++;
        }
        return ans;
    }

    public boolean isValidAnagaramViaFreqCount(String s, HashMap<Character, Integer> map) {
        int[] characterArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            characterArray[idx]++;
        }

        for (char ch : map.keySet()) {
            int idx = ch - 'a';
            if (characterArray[idx] != map.get(ch)) {
                return false;
            }
        }

        return true;
    }
}