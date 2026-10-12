class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = -1;
        while(j < s.length()) {
            char ch = s.charAt(j);
            if(!set.contains(ch)) {
                set.add(ch);  
            } else {
                int length = j - i;
                max = Math.max(max , length);
                while(s.charAt(i) != ch) {
                    if(set.contains(s.charAt(i))) set.remove(s.charAt(i)); 
                    i++;
                }
                i++;
            }
            j++;
        }
        int length = j - i;
        max = Math.max(max , length);
        return max;
    }
}