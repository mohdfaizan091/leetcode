class Solution {
    public int reverseBits(int n) {
        int i = 0;
        int j = 31;

        while(i < j) {
            int mask1 = 1 << j;
            int mask2 = 1 << i;

            if(((n & mask1) != 0) != ((n & mask2) != 0)) {
                // flip the ith and jth bit
                n ^= mask1;
                n ^= mask2;
            }

            i++;
            j--;
        }

        return n;
    }
}