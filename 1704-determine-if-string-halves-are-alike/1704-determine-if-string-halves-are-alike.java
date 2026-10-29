class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();

        String s1 = s.substring(0 , n/2);
        String s2 = s.substring(n/2);

        int v1 = countVowel(s1);
        int v2 = countVowel(s2);

        return v1 == v2;
    }

    public int countVowel(String s) {
        int vowelCount = 0;
        String str = s.toLowerCase();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }
        return vowelCount;
    }
}