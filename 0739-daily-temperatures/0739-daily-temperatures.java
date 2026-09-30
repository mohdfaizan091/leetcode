class Solution {
    public int[] dailyTemperatures(int[] temp) {

        int n = temp.length;

        int[] ans = new int[n];
        ans[n-1] = 0;

        Stack<Integer> st = new Stack<>();
        st.push(n-1);

        for(int i = n-2 ; i>= 0 ; i--) {
            if(!st.isEmpty() && temp[i] >= temp[st.peek()]) {
                while(!st.isEmpty() && temp[i] >= temp[st.peek()]) st.pop();
                if(st.isEmpty()) {ans[i] = 0;}
                else {int day = st.peek() - i;
                     ans[i] = day;}
            } else {
                int day = st.peek() - i;
                ans[i] = day;
            }
            st.push(i);
        }
        return ans;
    }
}