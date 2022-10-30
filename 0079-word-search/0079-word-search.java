class Solution {
        char[][] board;
        int rowSize;
        int colSize;
    
    public boolean exist(char[][] board, String word) {
    
        this.board = board;
        this.rowSize = board.length;
        this.colSize = board[0].length;
        
        for(int i=0; i<this.rowSize; i++){
            for(int j=0; j<this.colSize; j++){
                if(helper(i,j,word,0)) {
                    return true;
                }
            }
        }
        
        return false;

    }
    
    public boolean helper(int row, int col, String word, int index) {
        if (index>=word.length()) {
            return true;
        }
        
        if(row<0 || row>=this.rowSize || col<0 || col>=this.colSize || 
           this.board[row][col] != word.charAt(index)) {
            return false;
        }
        
        boolean ret = false; //it reaches here because word and board char match
        this.board[row][col] = '#';
        
        int[] x = {0,1,0,-1};
        int[] y = {1,0,-1,0};
        
        for(int d = 0; d<4; d++){
            ret = helper(row+x[d], col+y[d], word, index+1);
            if(ret==true) {
                break;
            }
        }
        
        this.board[row][col] = word.charAt(index); //backtrack
        return ret;
    }
}