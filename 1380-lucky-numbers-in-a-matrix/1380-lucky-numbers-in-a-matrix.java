class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> ans = new ArrayList<>();

        for(int i=0 ; i<row ; i++) {
            int luckyNumber = matrix[i][0];
            int idx = 0;
            for(int j=0 ; j<col ; j++) {
                if(matrix[i][j] < luckyNumber) {
                    luckyNumber = matrix[i][j];
                    idx = j;
                }
            }
            boolean lucky = true;
            for(int j=0 ; j<row ; j++) {
                if(matrix[j][idx] > luckyNumber) {
                    lucky = false;
                    break;
                }
            }
            
            if(lucky) {
                ans.add(luckyNumber);
            }
        }
        return ans;
    }
}