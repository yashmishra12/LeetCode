class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sr=0, sc = 0, er = matrix.length-1, ec = matrix[0].length-1;
        
        List<Integer> res = new ArrayList<>();
        
        while(sr<=er && sc<=ec) {
            
            for(int i=sc; i<=ec; i++) {
                res.add(matrix[sr][i]);
            }
            
            for(int i=sr+1; i<=er; i++) {
                res.add(matrix[i][ec]);
            }
            
            
            for(int i=ec-1; i>=sc; i--) {
                if(sr==er) break;
                res.add(matrix[er][i]);
            }
            
            
            for(int i=er-1; i>sr; i--){
                if(ec==sc) break;
                res.add(matrix[i][sc]);
            }
            
            sr++;
            er--;
            sc++;
            ec--;
        }
        
        return res;
    }
}