
class Solution {
    class pair {
        Character ch;
        int freq;

        pair(Character ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<pair> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (st.isEmpty()) {
                st.push(new pair(ch, 1));
            } else {
                pair top = st.peek();
                char ch1 = top.ch;
                int freq = top.freq;

                if (ch1 != ch) {
                    st.push(new pair(ch, 1));
                } else {
                    st.pop();
                    st.push(new pair(ch1, freq + 1));
                }

                top = st.peek();
                freq = top.freq;

                if (freq == k) {
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            pair top = st.pop();
            char ch2 = top.ch;

            for (int j = 0; j < top.freq; j++) {
                sb.append(ch2);
            }
        }

        return sb.reverse().toString();
    }
}