class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return minDistance(word1, word2, 0, 0, dp);
    }

    public int minDistance(String word1, String word2, int idx1, int idx2, int[][] dp) {

        if (idx1 == word1.length()) {
            return word2.length() - idx2;
        }

        if (idx2 == word2.length()) {
            return word1.length() - idx1;
        }
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        char ch1 = word1.charAt(idx1);
        char ch2 = word2.charAt(idx2);

        if (ch1 == ch2) {
            return dp[idx1][idx2] = minDistance(word1, word2, idx1 + 1, idx2 + 1, dp);
        }

        return dp[idx1][idx2] =  1 + Math.min(minDistance(word1, word2, idx1 + 1, idx2, dp),
                   Math.min(minDistance(word1, word2, idx1, idx2 + 1, dp), minDistance(word1, word2, idx1 + 1, idx2 + 1, dp)));
    }
}