class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int idx = -1;
        int countOne = -1;
        int[] ans = new int[2];
        for(int i=0 ; i<row ; i++) {
            int noOfOnes = 0;
            for(int j=0 ; j<col ; j++) {
                if(mat[i][j] == 1) {
                    noOfOnes++;
                }
            }
            if(noOfOnes > countOne) {
                countOne = noOfOnes;
                ans[1] = noOfOnes;
                ans[0] = i;
            }
        }
        return ans;
    }
}