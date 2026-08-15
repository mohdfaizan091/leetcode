class Solution {
    public boolean isPowerOfTwo(int n) {
        // return isPowerOfTwo1(n);
        return isPowerOfTwo2(n);
    }
    // approach 1 : bruteforce  TC = O(log(n))
    public boolean isPowerOfTwo1(int n) {
        if(n==0) return false;
        while(n%2 == 0) {
            n = n / 2;
        }
        if(n==1) return true;
        return false;
    }

    // approach 1 : TC = O(1)
    public boolean isPowerOfTwo2(int n) {
        if(n<=0) return false;
        if((n & (n-1)) == 0) return true;
        return false;
    }
}