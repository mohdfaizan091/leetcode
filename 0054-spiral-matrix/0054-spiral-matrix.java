class Solution { 
    public List<Integer> spiralOrder(int[][] matrix) { 
        List<Integer> ans = new ArrayList<>(); 
        int m = matrix.length; 
        int n = matrix[0].length; 
        
        int top_row = 0; 
        int top_col = 0; 
        int last_col = n - 1; 
        int last_row = m - 1; 
        
        while (top_row <= last_row && top_col <= last_col) { 
            // 1. Traverse Left to Right
            for (int i = top_col; i <= last_col; i++) { 
                ans.add(matrix[top_row][i]); 
            } 
            top_row++; 
            
            // 2. Traverse Top to Bottom
            for (int i = top_row; i <= last_row; i++) { 
                ans.add(matrix[i][last_col]); 
            } 
            last_col--; 
            
            // 3. Traverse Right to Left (CRITICAL CHECK ADDED)
            if (top_row <= last_row) {
                for (int i = last_col; i >= top_col; i--) { 
                    ans.add(matrix[last_row][i]); 
                } 
                last_row--; 
            }
            
            // 4. Traverse Bottom to Top (CRITICAL CHECK ADDED)
            if (top_col <= last_col) {
                for (int i = last_row; i >= top_row; i--) { 
                    ans.add(matrix[i][top_col]); 
                } 
                top_col++; 
            }
        } 
        return ans; 
    } 
}
