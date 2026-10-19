class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26]; 
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            
            char rightChar = s.charAt(right);
            counts[rightChar - 'A']++;
            
            maxFreq = Math.max(maxFreq, counts[rightChar - 'A']);

            if ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                counts[leftChar - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
