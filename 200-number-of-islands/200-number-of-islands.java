class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                
                if(grid[i][j]=='1') {
                    counter = counter + 1;
                    helper(grid, i, j);
                }
            }
        }
        
        return counter;
    }
    
    public void helper(char[][] grid, int row, int col) {
     
        if(row<0 || row>=grid.length || col<0 || col>=grid[row].length || grid[row][col] != '1') 
            return;
        
        grid[row][col] = '0';
        
        helper(grid, row+1, col);
        helper(grid, row, col+1);
        helper(grid, row-1, col);
        helper(grid, row, col-1);
    }
}