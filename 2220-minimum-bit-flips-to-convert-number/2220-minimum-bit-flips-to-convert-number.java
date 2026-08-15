class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        while(start != 0 || goal != 0) {
            if(start % 2 != goal % 2) {
                count++;
            }
            start = start >> 1;
            goal  = goal >> 1;
        }
        return count;
    }
}