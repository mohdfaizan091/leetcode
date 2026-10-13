class Solution {
    public boolean isValid(String s) {
    int n = s.length();
    int hyphenCount = 0;
    
    for (int i = 0; i < n; i++) {
        char ch = s.charAt(i);
        
        if (Character.isDigit(ch)) {
            return false;
        }
        if (ch == '-') {
            hyphenCount++;
            if (hyphenCount > 1 || i == 0 || i == n - 1) {
                return false;
            }
            if (!Character.isLowerCase(s.charAt(i - 1)) || !Character.isLowerCase(s.charAt(i + 1))) {
                return false;
            }
        }
        if (ch == '!' || ch == '.' || ch == ',') {
            if (i != n - 1) {
                return false;
            }
        }
    }
    return true;
}

    public int countValidWords(String sentence) {
        int count = 0;
        String s = sentence.trim();
        String[] str = s.split("\\s+");
        for(int i=0 ; i<str.length ; i++) {
            String s1 = str[i];
            if(isValid(s1)) count++;
        }
        return count;
    }
}