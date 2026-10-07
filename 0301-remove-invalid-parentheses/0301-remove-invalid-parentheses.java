class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();

        int left = 0;
        int right = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        solve(s, 0, left, right, list, new StringBuilder());

        return list;
    }

    public void solve(String s, int idx, int left, int right,
                      List<String> list, StringBuilder ans) {

        if (idx == s.length()) {
            if (left == 0 && right == 0 && isValid(ans)) {
                String str = ans.toString();

                if (!list.contains(str)) {
                    list.add(str);
                }
            }
            return;
        }

        char ch = s.charAt(idx);

        if (ch == '(' && left > 0) {
            solve(s, idx + 1, left - 1, right, list, ans);
        }

        if (ch == ')' && right > 0) {
            solve(s, idx + 1, left, right - 1, list, ans);
        }

        ans.append(ch);
        solve(s, idx + 1, left, right, list, ans);
        ans.deleteCharAt(ans.length() - 1);
    }

    public boolean isValid(StringBuilder s) {
        int balance = 0;

        for (char ch : s.toString().toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}