class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                StringBuilder sb = new StringBuilder();
                while (st.peek() != '[') {
                    sb.append(st.pop());
                }
                sb.reverse();
                st.pop();

                int k = 0;
                int place = 1;
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    k = (st.pop() - '0') * place + k;
                    place *= 10;
                }
                for (int j = 0; j < k; j++) {
                    for (int x = 0; x < sb.length(); x++) {
                        st.push(sb.charAt(x));
                    }
                }
            } else {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}