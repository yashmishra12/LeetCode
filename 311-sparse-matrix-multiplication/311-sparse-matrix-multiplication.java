class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        
        int n = mat1.length; //mat1 ROW
        int k = mat1[0].length; //mat 1 COL
        int m = mat2[0].length; //mat 2 ROW
        
        // MAT 1 (nxk) x MAT 2 (k*m);
        
        int[][] res = new int [n][m];
            
            for(int row=0; row<n; row++) {
                for(int el = 0; el<k; el++) {
                    
                    if(mat1[row][el] != 0) {
                        for(int col=0; col<m; col++) {
                            
                            res[row][col] += mat1[row][el]*mat2[el][col];
                        }
                    }
                }
            }
        
        return res;
        
    }
}