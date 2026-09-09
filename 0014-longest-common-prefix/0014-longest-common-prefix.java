class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String ans = "";
        String str = strs[0];
        for(int i=1 ; i<strs.length ; i++) {
            ans = "";
            int n = Math.min(str.length() , strs[i].length());
            for(int j=0 ; j<n ; j++) {
                char ch1 = strs[i].charAt(j);
                char ch2 = str.charAt(j);
                if(ch1 == ch2) {
                    ans += ch1;
                } else { break;}
            }
            str = ans;
        }
        return ans;
    }
}