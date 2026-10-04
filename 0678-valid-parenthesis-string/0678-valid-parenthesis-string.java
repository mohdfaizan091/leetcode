class Solution {
    Boolean[][] dp;

    public boolean checkValidString(String s) {
        int n= s.length() + 1;

        dp = new Boolean[n][n];
        return DP(s, 0, 0);
    }

    public boolean DP(String s, int idx, int balance) {
        if (balance < 0) {
            return false;
        }

        if (idx == s.length()) {
            return balance == 0;
        }

        if (dp[idx][balance] != null) {
            return dp[idx][balance];
        }

        char ch = s.charAt(idx);

        if (ch == '(') {
            return dp[idx][balance] = DP(s, idx + 1, balance + 1);
        }

        if (ch == ')') {
            return dp[idx][balance] = DP(s, idx + 1, balance - 1);
        }

        return dp[idx][balance] =
                DP(s, idx + 1, balance + 1)
                || DP(s, idx + 1, balance - 1)
                || DP(s, idx + 1, balance);
    }
}