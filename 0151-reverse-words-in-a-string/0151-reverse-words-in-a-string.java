class Solution {
    public String reverseWords(String s) {
        String S= s.trim();
        String[] str = S.split("\\s+");
        int n = str.length;
        StringBuilder sb = new StringBuilder();
        for(int i=n-1 ; i>=0 ; i--) {
            if(i != 0) {
                sb.append(str[i]);
                sb.append(" ");
            } else {
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }
}