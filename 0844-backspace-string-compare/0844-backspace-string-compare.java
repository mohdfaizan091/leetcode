class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch == '#') {
                if(sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(ch);
            }
        }

        StringBuilder yb = new StringBuilder();
        for(char ch : t.toCharArray()) {
            if(ch == '#') {
                if(yb.length() > 0) {
                    yb.deleteCharAt(yb.length() - 1);
                }
            } else {
                yb.append(ch);
            }
        }
        String s1 = new String(sb);
        String s2 = new String(yb);

        return s1.equals(s2);
    }
}