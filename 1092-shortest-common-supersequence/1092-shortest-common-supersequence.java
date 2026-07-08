class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {

        String common = longestCommonSubsequence(str1, str2);

        StringBuilder ans = new StringBuilder();

        int i = 0;
        int j = 0;
        int k = 0;

        while (k < common.length()) {

            while (i < str1.length() && str1.charAt(i) != common.charAt(k)) {
                ans.append(str1.charAt(i));
                i++;
            }

            while (j < str2.length() && str2.charAt(j) != common.charAt(k)) {
                ans.append(str2.charAt(j));
                j++;
            }

            ans.append(common.charAt(k));
            i++;
            j++;
            k++;
        }

        while (i < str1.length()) {
            ans.append(str1.charAt(i));
            i++;
        }

        while (j < str2.length()) {
            ans.append(str2.charAt(j));
            j++;
        }

        return ans.toString();
    }

    public String longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return printLCS(dp, text1, text2);
    }

    public String printLCS(int[][] dp, String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        StringBuilder sb = new StringBuilder();

        while (m > 0 && n > 0) {

            if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
                sb.append(text1.charAt(m - 1));
                m--;
                n--;
            } else if (dp[m - 1][n] >= dp[m][n - 1]) {
                m--;
            } else {
                n--;
            }
        }

        return sb.reverse().toString();
    }
}