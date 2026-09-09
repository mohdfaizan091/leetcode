class Solution {
    int value(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    public boolean priority(char ch1 , char ch2) {
        int v1 = value(ch1);
        int v2 = value(ch2);
        if(v2 > v1) return true;
        return false;
    }
    public int romanToInt(String s) {
        int ans = 0;
        char ch = s.charAt(0);
        ans += value(ch);
        for(int i=1; i<s.length() ; i++) {
            char ch1 = s.charAt(i-1);
            char ch2 = s.charAt(i);
            if(priority(ch1 , ch2)) {
                ans += value(ch2) - 2 * value(ch1);
            } else {
                ans += value(ch2);
            }
        }
        return ans;
    }
}