class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = (matrix.length * matrix.length) - k + 1;
        
        return helper(matrix, m);
    }
    
    public static int helper(int[][] matrix, int k) {
        for(int i=0; i<k-1; ++i) {
            reArrange (matrix, matrix.length-1, matrix[0].length-1);
        }
            
        return matrix[matrix.length-1][matrix[0].length-1];    
    }
    
    public static void reArrange (int[][] matrix, int row, int col){
        int newRow = 0, newCol = 0;
        
        if(row==0 && col==0) {
            matrix[row][col] = Integer.MIN_VALUE;
            return;
        }
        else if(row==0){
            newRow = row;
            newCol = col-1;
        } 
        else if(col==0) {
            newRow = row - 1;
            newCol = col;
        } 
        else if(matrix[row][col-1]>matrix[row-1][col]) {
            newRow = row;
            newCol = col-1;
        } 
        else {
            newRow = row-1;
            newCol = col;
        }
        
        matrix[row][col] = matrix[newRow][newCol];
        reArrange(matrix, newRow, newCol);
    }
}