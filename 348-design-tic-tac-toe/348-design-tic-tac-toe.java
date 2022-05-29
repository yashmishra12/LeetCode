class TicTacToe {

    int n;
    int[] row;
    int[] col;
    int diag1 = 0;
    int diag2 = 0;
    
    public TicTacToe(int n) {
        this.n = n;
        row = new int[n];
        col = new int[n];
    }
    
    public int move(int r, int c, int player) {
        int inc = 1;
        
        if(player==2) {inc = -1;}
        
        row[r] += inc;
        if(row[r]==n || row[r]==-n) {return player;}
        
        col[c] += inc;
        if(col[c]==n || col[c]==-n) {return player;}
        
        if(r==c) {
            diag1+=inc;
            
            if(diag1==n || diag1 ==-n) {return player;}
        }
        
        if(r+c == n-1) {
            diag2 += inc;
            if(diag2==n || diag2==-n) {return player;}
        }
        
        return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */