class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int ans = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
                i++;
            } else {
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2;
                } else {
                    ans++;
                    i++;
                }

                if (open > 0) {
                    open--;
                } else {
                    ans++;
                }
            }
        }

        return ans + 2 * open;
    }
}