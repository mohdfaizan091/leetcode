class Solution {
    public int countSubstrings(String s) {
        //bruteforce - Approach 1
        return Substring(s);
    }
    public int Substring(String s) {
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