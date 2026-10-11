class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
    
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        
        String str = sb.toString();
        int i = 0;
        int j = str.length() - 1;
        while(i < j) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);
            if(ch1 != ch2) return false;
            i++;
            j--;
        }
        return true;
    }
}