class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<String> st = new Stack<>();
        Queue<String> ans = new LinkedList<>();

        String str = words[0];
        ans.add(str);
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        String s = new String(ch);
        st.push(s);

        for(int i=1 ; i<words.length ; i++) {
            String str1 = words[i];
            char[] ch1 = str1.toCharArray();
            Arrays.sort(ch1);
            String s2 = new String(ch1);
            if(!s2.equals(st.peek())) {
                st.push(s2);
                ans.add(str1);
            }
        }

        List<String> result = new ArrayList<>();
        while(!ans.isEmpty()) {
            result.add(ans.remove());
        }
        return result;
    }
}