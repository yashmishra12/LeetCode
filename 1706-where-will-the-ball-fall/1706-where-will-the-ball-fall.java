class Solution {
    public int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[] ans = new int[col];
        for(int j=0; j<col; j++){
            int curPos = j;
            int newPos;
            
            for(int i=0; i<row; i++) {
                newPos = curPos + grid[i][curPos];
                
                if(newPos<0 || newPos>=col || grid[i][curPos] != grid[i][newPos]){
                    curPos = -1;
                    break;
                }
                
                curPos = newPos;
            }
            
            ans[j] = curPos;
        }
        
        return ans;
        
    }
}