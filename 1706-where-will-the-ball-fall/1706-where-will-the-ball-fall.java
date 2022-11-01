class Solution {
    public int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[] ans = new int[col];
        for(int j=0; j<col; j++){
            int curCol = j;
            int newCol;
            
            for(int i=0; i<row; i++) {
                newCol = curCol + grid[i][curCol]; //+1 --> right, -1 ---> left
                
                if(newCol<0 || newCol>=col || grid[i][curCol] != grid[i][newCol]){ //3rd cond --> interescting lines
                    curCol = -1;
                    break;
                }
                
                curCol = newCol;
            }
            
            ans[j] = curCol;
        }
        
        return ans;
        
    }
}