class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if(n != goal.length()) return false;
        for(int i=0 ; i<n ; i++) {
            String str = s.substring(i + 1 , n) + s.substring(0, i+1);
            System.out.print(str + " ");
            if(goal.equals(str)) return true;
        }
        return false;
    }
}