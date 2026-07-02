class Solution {
    static int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder sb1 = new StringBuilder(text1);
        StringBuilder sb2 = new StringBuilder(text2);

        int m = sb1.length();
        int n = sb2.length();

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return CommonSubsequence(sb1, sb2, m - 1, n - 1);
    }

    public int CommonSubsequence(StringBuilder text1, StringBuilder text2, int idx1, int idx2) {
        if (idx1 < 0 || idx2 < 0)
            return 0;

        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2];

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + CommonSubsequence(text1, text2, idx1 - 1, idx2 - 1);
        }

        return dp[idx1][idx2] = Math.max(
                CommonSubsequence(text1, text2, idx1 - 1, idx2),
                CommonSubsequence(text1, text2, idx1, idx2 - 1));
    }
}