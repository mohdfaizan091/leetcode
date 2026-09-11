class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        boolean[] isUsed = new boolean[n];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0 ; i<n ; i++) {
            if(digits[i] == 0) continue;
            isUsed[i] = true;
            for(int j=0 ; j<n ; j++) {
                if(isUsed[j]) continue;
                isUsed[j] = true;
                for(int k=0 ; k<n ; k++) {
                    if(isUsed[k]) continue;
                    if(digits[k]%2 == 1) continue;
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    set.add(num);
                }
                isUsed[j] = false;
            }
            isUsed[i] = false;
        }
        return set.size();
    }
}