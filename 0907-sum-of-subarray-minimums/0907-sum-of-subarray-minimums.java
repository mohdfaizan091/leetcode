class Solution {
    long MOD = 1000000007L;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long sum = 0;

        for(int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            sum += ((long) arr[i] * left * right) % MOD;
            sum %= MOD;
        }

        return (int) sum;
    }
}