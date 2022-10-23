class Solution {
    public boolean checkValid(int[][] matrix) {

        
        int len = matrix.length;
        boolean[] m;
        
        for(int[] i : matrix){
            m = new boolean[len+1];
            for(int j : i){
                if(m[j])
                    return false;
                m[j] = true;
            }
        }
        
        for(int i = 0; i < len; i++){
            m = new boolean[len+1];
            for(int j = 0; j < len; j++){
                if(m[matrix[j][i]])
                    return false;
                m[matrix[j][i]] = true;
            }
        }
        
        return true;
    }

}