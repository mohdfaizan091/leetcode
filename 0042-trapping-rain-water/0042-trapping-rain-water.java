class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        int[] previousGreatestElement = new int[n];
        previousGreatestElement[0] = height[0];

        Stack<Integer> st = new Stack<>();
        st.push(height[0]);
        for(int i=1 ; i<n ; i++) {
            if(height[i] > st.peek()) {
                st.pop();
                st.push(height[i]);
            }
            previousGreatestElement[i] = st.peek();
        }

        while(!st.isEmpty()) st.pop();

        int[] nextGreatestElement = new int[n];
        previousGreatestElement[n-1] = height[n-1];
        st.push(height[n-1]);

        for(int i=n-2 ; i>=0 ; i--) {
            if(height[i] > st.peek()) {
                st.pop();
                st.push(height[i]);
            }
            nextGreatestElement[i] = st.peek();
        }

        for(int i=1 ; i<n-1 ; i++) {

            int leftMax = previousGreatestElement[i];
            int rightMax = nextGreatestElement[i];
            int min = Math.min(leftMax , rightMax);
            ans += min - height[i];

        }
        return ans;
    }
}