class Solution {
    public boolean isPowerOfFour(int n) {
        return isPower3(n);
    }
    // appraoch : 01
    public boolean isPower1(int n) {
        if(n <= 0) return false;
        while(n % 4 == 0){
            n = n / 4;
        }
        if(n == 1) return true;
        return false;
    }

    // appraoch : 02 (intitution : power of 4 is always a power of 2 but power of 2 is not always power of 4);
    public boolean isPower2(int n) {
        return ((n & (n - 1)) == 0 && isSquare(n));
    }
    public boolean isSquare(int n) {
        int root = (int) Math.sqrt(n);
        return root * root == n;
    }

    // appraoch : 03 (intitution : power of 4 mod 3 always eqaul == 1);
    public boolean isPower3(int n) {
        return ((n & (n - 1)) == 0 && n % 3 == 1);
    }
}