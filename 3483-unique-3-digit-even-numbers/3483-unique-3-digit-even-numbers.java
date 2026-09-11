class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        int count = 0;

        for (int i = 0; i < digits.length; i++) {
            freq[digits[i]]++;
        }

        for (int i = 100; i < 1000; i++) {
            if (i % 2 != 0) {
                continue;
            }
            int d1 = i % 10;
            int d2 = (i / 10) % 10;
            int d3 = i / 100;
            int[] temp = freq.clone();
            if (temp[d1] > 0) {
                temp[d1]--;
                if (temp[d2] > 0) {
                    temp[d2]--;
                    if (temp[d3] > 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}