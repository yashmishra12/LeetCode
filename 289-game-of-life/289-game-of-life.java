class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dirs = new int[][] {{1,0}, {0, 1}, {1,1}, 
                                    {-1,0},{0,-1}, {-1, -1},
                                    {1,-1}, {-1,1}};
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int aliveCount=0;
                
                for(int[] d: dirs) {
                    int p = i+d[0];
                    int q = j+d[1];
                    if(outOfBound(p,q,board)) continue;
                    if(board[p][q]==1 || board[p][q]==2) aliveCount++;
                }
                
                if(board[i][j]==1) {
                    if(aliveCount<2 || aliveCount>3) board[i][j]=2;
                } else {
                    if (aliveCount==3) {
                        board[i][j] = 3;
                    }
                }
      
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = board[i][j]%2;
            }
        }
        
    }
    
    public static boolean outOfBound(int a, int b, int[][] arr) {
        if (a<0 || a>=arr.length || b<0 || b>=arr[0].length) return true;
        return false;
    }
}