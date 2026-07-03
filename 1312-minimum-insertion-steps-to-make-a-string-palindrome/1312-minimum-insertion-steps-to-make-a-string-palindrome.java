class Solution {
    static int[][] dp;
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j]=-1;
            }
        }
        int ans = minStep(s, 0, n-1);
        return n - ans;
    }

    public int minStep(String s, int left, int right) {
        if(left == right) return 1;
        if(left > right) return 0;
        if(dp[left][right] != -1) return dp[left][right];
        char ch1 = s.charAt(left);
        char ch2 = s.charAt(right);
        if(ch1 == ch2) {
            return dp[left][right] = 2 + minStep(s, left + 1, right - 1);
        }
        else {
            return dp[left][right] = Math.max(minStep(s, left + 1, right), minStep(s, left, right - 1));
        }
    }
}