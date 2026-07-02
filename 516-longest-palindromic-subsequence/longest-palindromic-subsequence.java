class Solution {
    static int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j]=-1;
            }
        }
        return PalindromeSubseq(s, 0, n-1);
    }
    public int PalindromeSubseq(String s, int left, int right) {
        if(left == right) return 1;
        if(left > right) return 0;
        if(dp[left][right] != -1) return dp[left][right];
        char ch1 = s.charAt(left);
        char ch2 = s.charAt(right);
        if(ch1 == ch2) {
            return dp[left][right] = 2 + PalindromeSubseq(s, left + 1, right - 1);
        }
        else {
            return dp[left][right] = Math.max(PalindromeSubseq(s, left + 1, right), PalindromeSubseq(s, left, right - 1));
        }
    }
}