class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        for(int i=0; i<4; i++) {
            int[][] pot = rotate(mat);
            if (match(pot, target)) return true;
        }
        
        return false;
        
    }
        public static int[][] rotate(int[][] matrix) {
        Collections.reverse(Arrays.asList(matrix));
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
                return matrix;
    }
    
    public static boolean match(int[][] a, int[][] b) {
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a[i].length; j++){
                if(a[i][j]!=b[i][j]) return false;
            } 
        }
        
        return true;
    }

}