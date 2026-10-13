class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        for(int i=0 ; i<n ; i++) {
            char ch = s.charAt(i);
            boolean isRepeating = false;
            for(int j=0 ; j<n ; j++) {
                if(i != j) {
                    if(ch == s.charAt(j)) {
                        isRepeating = true;
                        break;
                    }
                }
            }
            if(!isRepeating) return i;
        }
        return -1;
    }
}