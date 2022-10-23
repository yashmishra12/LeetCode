class Solution {
    public boolean checkValid(int[][] matrix) {
//         for(int i=0; i<matrix.length;i++) {
//             ArrayList<Integer> row = new ArrayList<>();
//             for(int n: matrix[i]) {
//                 row.add(n);
//             }
//             if(!check(row)) {return false;}
//             ArrayList<Integer> col = new ArrayList<>();
            
//             for(int j=0; j<matrix[i].length;j++) {
//                 col.add(matrix[i][j]);
//             }
//              if(!check(col)) {return false;}
//         }
        
//         return true;
        
        int n = matrix.length;

    for(int r = 0; r < n; r ++){
// rvis = row visited
// cvis = coloum visited;

        boolean rvis[] = new boolean[n + 1]; // row wise
        boolean cvis[] = new boolean[n + 1];//col wise
        
        for(int c = 0; c < n; c ++){
            int rval = matrix[r][c]; //row wise
            int cval = matrix[c][r]; //col wise
            
            if(rvis[rval] == true || cvis[cval] == true){
// Element occurs more than once;

                return false; // Matrix is not valid;
            }
         
            rvis[rval] = true;
        cvis[cval] = true;
    }
}
 
    return true; // Matrix valid;
    }
    

}