class Solution {
    public int[][] candyCrush(int[][] board) {
        int R = board.length, C = board[0].length;
        boolean todo = false;
        
        //row CRUSH
        for(int r=0; r<R; r++) {
            for(int c= 0; c<C-2; c++) { //we will check the next two cols
                int v = Math.abs(board[r][c]);
                
                //crush
                if(v!=0 && v==Math.abs(board[r][c+1]) && v==Math.abs(board[r][c+2])){
                    board[r][c] = board[r][c+1] = board[r][c+2] = -v;
                    todo = true;
                }
            }
        }
        
        //col CRUSH
        for(int r=0; r<R-2; r++) {
            for(int c=0; c<C; c++) { //we will check the next two rows
                int v = Math.abs(board[r][c]);
                if(v!=0 && v==Math.abs(board[r+1][c]) && v==Math.abs(board[r+2][c])){
                    board[r][c] = board[r+1][c] = board[r+2][c] = -v;
                    todo=true;
            }
        }
    }
        
        for(int c=0; c<C; c++) {
            int anchor_row = R-1;
            for(int r=R-1; r>=0; r--) {
                if(board[r][c]>0){
                    board[anchor_row][c] = board[r][c];
                    anchor_row--;
                }
            }
            
            while(anchor_row>=0) {
                board[anchor_row--][c] = 0; //filling empty spaces
            }
            
        }
        return todo ? candyCrush(board):board;
}
}