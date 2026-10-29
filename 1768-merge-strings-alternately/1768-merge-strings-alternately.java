class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i<word1.length() && j < word2.length()) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(j);
            sb.append(ch1);
            sb.append(ch2);
            i++;
            j++;
        }
        if(i < word1.length()) {
            String s = word1.substring(i);
            sb.append(s);
        }
        if(j < word2.length()) {
            String s = word2.substring(i);
            sb.append(s);
        }
        return sb.toString();
    }
}