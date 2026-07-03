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
        return minStep(s, 0, s.length() - 1);
    }

    public int minStep(String s, int left, int right) {
        if (left >= right)
            return 0;
        if(dp[left][right] != -1) return dp[left][right];
        if (s.charAt(left) == s.charAt(right)) {
            return minStep(s, left + 1, right - 1);
        }

        return dp[left][right] =  1 + Math.min(
                minStep(s, left + 1, right),
                minStep(s, left, right - 1));
    }
}