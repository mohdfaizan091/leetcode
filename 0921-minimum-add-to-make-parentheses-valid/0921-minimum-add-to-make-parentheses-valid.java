class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0 ; i<n ; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(ch);
            }
            else {
                if(st.isEmpty()) {
                    st.push(')');
                }
                else if(st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(')');
                }
            }
        }
        return st.size();
    }
}