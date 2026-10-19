class Solution {
    public int diagonalSum(int[][] mat) {
        int i = 0;
        int n = mat.length;
        int ans = 0;

        for(int j=0 ; j<n ; j++) {
            ans += mat[i][j];
            i++;
        }
        
        i = n - 1;
        for(int j=0 ; j<n ; j++) {
            if(i != j) {
                ans += mat[i][j];
            }
            i--;
        }
        return ans;
    }
}