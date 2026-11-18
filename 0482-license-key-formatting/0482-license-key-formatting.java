class Solution {
    public String licenseKeyFormatting(String s, int k) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int K = k;
        List<String> list = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '-') {
                continue; 
            }

            if (K != 1) {
                st.push(ch);
                K--;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(ch); 
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
                list.add(sb.toString());
                K = k;
            }
        }

        if (!st.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
            list.add(sb.toString());
        }

        StringBuilder ans = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            ans.append(list.get(i));
            if (i != 0) {
                ans.append("-");
            }
        }

        return ans.toString().toUpperCase();
    }
}
