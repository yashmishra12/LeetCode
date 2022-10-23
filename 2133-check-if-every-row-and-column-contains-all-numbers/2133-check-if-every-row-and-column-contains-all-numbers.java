class Solution {
    public boolean checkValid(int[][] matrix) {

        
        int len = matrix.length;
        boolean[] m;
                boolean[] m2;
        
        // for(int[] i : matrix){
        //     m = new boolean[len+1];
        //     for(int j : i){
        //         if(m[j]){return false;}
        //         m[j] = true;
        //     }
        // }
        
        for(int i = 0; i < len; i++){
            
            m2 = new boolean[len+1];
            int[] i2 = matrix[i];
            for(int j : i2){
                if(m2[j]){return false;}
                m2[j] = true;
            }
            
            m = new boolean[len+1];
            for(int j = 0; j < len; j++){
                if(m[matrix[j][i]]){return false;}
                m[matrix[j][i]] = true;
            }
        }
        
        return true;
    }

}