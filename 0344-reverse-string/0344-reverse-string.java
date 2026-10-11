class Solution {
    public void reverseString(char[] s) {
        char[] ans = new char[s.length];
        int k=0;
        int n = s.length-1;
        for(int i=n ; i>=0 ; i--) {
            ans[k] = s[i];
            k++;
        }
        for(int i=0 ; i<=n ; i++) {
            s[i] = ans[i];
        }
    }
}