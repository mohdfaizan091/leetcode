class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder ans = new StringBuilder();
        char carry = '0';
        int i = s1.length() - 1, j = s2.length() - 1;

        while (i >= 0 && j >= 0) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(j);

            if ((ch1 == '1' && ch2 == '0') || (ch1 == '0' && ch2 == '1')) {
                if (carry == '0') {
                    ans.append('1');
                    carry = '0';
                } else { 
                    ans.append('0');
                    carry = '1';
                }
            } else if (ch1 == '1' && ch2 == '1') {
                if (carry == '0') {
                    ans.append('0');
                    carry = '1';
                } else {
                    ans.append('1');
                    carry = '1';
                }
            } else if (ch1 == '0' && ch2 == '0') {
                if (carry == '1') {
                    ans.append('1');
                    carry = '0';
                } else {
                    ans.append('0');
                    carry = '0';
                }
            }
            i--;
            j--;
        }

       
        while (i >= 0) {
            char ch1 = s1.charAt(i);
            if (ch1 == '1' && carry == '1') {
                ans.append('0');
                carry = '1';
            } else if (ch1 == '1' && carry == '0') {
                ans.append('1');
                carry = '0';
            } else if (ch1 == '0' && carry == '1') { 
                ans.append('1');
                carry = '0';
            } else {
                ans.append('0');
                carry = '0';
            }
            i--;
        }

        while (j >= 0) {
            char ch2 = s2.charAt(j); 
            if (ch2 == '1' && carry == '1') {
                ans.append('0');
                carry = '1';
            } else if (ch2 == '1' && carry == '0') {
                ans.append('1');
                carry = '0';
            } else if (ch2 == '0' && carry == '1') { 
                ans.append('1');
                carry = '0';
            } else {
                ans.append('0');
                carry = '0';
            }
            j--;
        }

        if (carry == '1') {
            ans.append('1');
        }

        ans.reverse();
        int start = 0;
        while (start < ans.length() - 1 && ans.charAt(start) == '0') {
            start++;
        }

        return ans.substring(start);
    }
}