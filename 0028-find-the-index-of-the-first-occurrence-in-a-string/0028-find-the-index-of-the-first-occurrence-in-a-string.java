class Solution {
    public int strStr(String s1, String tar) {
        if (tar.isEmpty()) return 0;
        
        int m = s1.length();
        int n = tar.length();
        
        
        for (int i = 0; i <= m - n; i++) {
            if (s1.substring(i, i + n).equals(tar)) {
                return i;
            }
        }
        
        return -1;
    }
}
