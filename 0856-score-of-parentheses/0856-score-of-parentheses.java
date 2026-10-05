class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(0);
            } else {
                int v = st.pop();

                if (v == 0) {
                    v = 1;
                } else {
                    v = 2 * v;
                }

                int top = st.pop();
                st.push(top + v);
            }
        }

        return st.pop();
    }
}