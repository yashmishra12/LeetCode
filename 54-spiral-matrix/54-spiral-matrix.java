class Solution {
    public List<Integer> spiralOrder(int[][] array) {
       List<Integer> res = new ArrayList<>();
        int sr = 0;
        int sc = 0;
        int er = array.length-1;
        int ec = array[0].length-1;

        while(sr<=er && sc<=ec){
					
            for(int i = sc; i<=ec; i++){
                res.add(array[sr][i]);
            }
					
            for(int i = sr+1; i<=er; i++){
                res.add(array[i][ec]);
            }
					
            for(int i=ec-1; i>=sc; i--){
                if(sr==er) break;
                res.add(array[er][i]);
            }
					
            for(int i=er-1; i>sr; i--){
                if(ec==sc) break;
                res.add(array[i][sc]);
            }
					
            sc++; // -->
            ec--; // <--
            sr++; // V
            er--; // ^
        }

        return res;
    }
}