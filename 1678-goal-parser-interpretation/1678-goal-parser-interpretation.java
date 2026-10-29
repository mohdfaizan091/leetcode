class Solution {
    public String interpret(String command) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : command.toCharArray()) {
            if(ch == 'G') {
                sb.append(ch);
            } else if(ch == '(') {
                st.push(ch);
            } else if(ch == ')') {
                if(st.peek() == '(') {
                    sb.append('o');
                    st.pop();
                } else {
                    sb.append("al");
                    while(!st.isEmpty() && st.peek() != ')') st.pop();
                    if(!st.isEmpty()) st.pop();
                }
            } else {
                st.push(ch);
            }
        }
        return sb.toString();
    }
}