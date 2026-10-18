class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];

        int mal = magazine.length();
        int ranl = ransomNote.length();

        for(int i=0 ; i<mal ; i++) {
            char ch = magazine.charAt(i);
            int idx = ch - 'a';
            count[idx]++;
        }

        for(int i=0 ; i<ranl ; i++) {
            char ch = ransomNote.charAt(i);
            int idx = ch - 'a';
            if(count[idx] <= 0) return false;
            else count[idx]--;
        }
        return true;
    }
}