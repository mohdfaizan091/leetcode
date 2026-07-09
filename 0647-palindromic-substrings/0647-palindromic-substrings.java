class Solution {
    public int countSubstrings(String s) {
        return Sub_string(s);
    }
    public int Sub_string(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];

    // length-1 substrings are always palindromes
    for (int i = 0; i < n; i++) {
        dp[i][i] = 1;
    }
    int j = 1;
    while (j < n) {
        int p = 0;
        int q = j;
        while (q < n) {
            if (s.charAt(p) != s.charAt(q)) {
                dp[p][q] = 0;
            } else {
                if (q - p == 1) {
                    dp[p][q] = 1;
                } else if (dp[p + 1][q - 1] == 1) {
                    dp[p][q] = 1;
                } else {
                    dp[p][q] = 0;
                }
            }
            p++;
            q++;
        }
        j++; 
    }

    int count = 0;
    for (int l = 0; l < n; l++) {
        for (int m = 0; m < n; m++) {
            if (dp[l][m] == 1)
                count++;
        }
    }
    return count;
}
    public int Substring(String s) {
        //bruteforce - Approach 1
        int count = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                if(isPalindrome(s, i,j)) count++;
            }
        }
        return count;
    }
    public boolean isPalindrome(String s, int left, int right) {
        int i = left;
        int j = right;
        while(i<=j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}