class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max =0;
        int[] arr = new int[2];
        int row = mat.length;
        int col = mat[0].length;
        for(int i =0;i<row;i++){
            int count=0;
            for(int j =0;j<col;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            if(count>max){
                max = count;
                arr[0] = i;
                arr[1] = max;
            }
        }
        return arr;
    }
}