class Solution {
    static int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    // public int CommonSubsequence(StringBuilder text1, StringBuilder text2, int idx1, int idx2) {
    //     if (idx1 < 0 || idx2 < 0)
    //         return 0;

    //     if (dp[idx1][idx2] != -1)
    //         return dp[idx1][idx2];

    //     if (text1.charAt(idx1) == text2.charAt(idx2)) {
    //         return dp[idx1][idx2] = 1 + CommonSubsequence(text1, text2, idx1 - 1, idx2 - 1);
    //     }

    //     return dp[idx1][idx2] = Math.max(
    //             CommonSubsequence(text1, text2, idx1 - 1, idx2),
    //             CommonSubsequence(text1, text2, idx1, idx2 - 1));
    // }
}