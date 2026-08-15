class Solution {
    public int hammingWeight(int n) {
        return noOfOnes2(n);
    }
    // approach 1 : bruteforce TC : O(32);
    public int noOfOnes1(int n) {
        int count = 0;
        while(n != 0) {
            if(n % 2 != 0) count++;
            n = n>>1;
        }
        return count;
    }
    // approach 2 : bruteforce TC : O(count);
    public int noOfOnes2(int n) {
        int count = 0;
        while(n != 0) {
            n = (n & (n-1));
            count++;
        }
        return count;
    }

}
