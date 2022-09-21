// class Solution {
//     private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
//     private int numRows;
//     private int numCols;
//     private int[][] landHeights;
    
//     public List<List<Integer>> pacificAtlantic(int[][] matrix) {
//         // Check if input is empty
//         if (matrix.length == 0 || matrix[0].length == 0) {
//             return new ArrayList<>();
//         }
        
//         // Save initial values to parameters
//         numRows = matrix.length;
//         numCols = matrix[0].length;
//         landHeights = matrix;
//         boolean[][] pacificReachable = new boolean[numRows][numCols];
//         boolean[][] atlanticReachable = new boolean[numRows][numCols];
        
//         // Loop through each cell adjacent to the oceans and start a DFS
//         for (int i = 0; i < numRows; i++) {
//             dfs(i, 0, pacificReachable);
//             dfs(i, numCols - 1, atlanticReachable);
//         }
//         for (int i = 0; i < numCols; i++) {
//             dfs(0, i, pacificReachable);
//             dfs(numRows - 1, i, atlanticReachable);
//         }
        
//         // Find all cells that can reach both oceans
//         List<List<Integer>> commonCells = new ArrayList<>();
//         for (int i = 0; i < numRows; i++) {
//             for (int j = 0; j < numCols; j++) {
//                 if (pacificReachable[i][j] && atlanticReachable[i][j]) {
//                     commonCells.add(List.of(i, j));
//                 }
//             }
//         }
//         return commonCells;
//     }
    
//     private void dfs(int row, int col, boolean[][] reachable) {
//         // This cell is reachable, so mark it
//         reachable[row][col] = true;
//         for (int[] dir : DIRECTIONS) { // Check all 4 directions
//             int newRow = row + dir[0];
//             int newCol = col + dir[1];
//             // Check if new cell is within bounds
//             if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
//                 continue;
//             }
//             // Check that the new cell hasn't already been visited
//             if (reachable[newRow][newCol]) {
//                 continue;
//             }
//             // Check that the new cell has a higher or equal height,
//             // So that water can flow from the new cell to the old cell
//             if (landHeights[newRow][newCol] < landHeights[row][col]) {
//                 continue;
//             }
//             // If we've gotten this far, that means the new cell is reachable
//             dfs(newRow, newCol, reachable);
//         }
//     }
// }

class Solution {
    
   int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
   public List<List<Integer>> pacificAtlantic(int[][] matrix) {
       List<List<Integer>> res = new ArrayList<>();
       
       if(matrix==null || matrix.length==0 || matrix[0].length==0) {
           return res;
       }
       
       int row = matrix.length, col = matrix[0].length;
       
       boolean[][] pacific = new boolean[row][col];
       boolean[][] atlantic = new boolean[row][col];
       
       
       //cols near ocean
       for(int i=0; i<col; i++) {
           dfs(matrix, 0, i, Integer.MIN_VALUE, pacific);
           dfs(matrix, row-1, i, Integer.MIN_VALUE, atlantic);
       }
       
       //rows near ocean
       for(int i=0; i<row; i++) {
           dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
           dfs(matrix, i, col-1, Integer.MIN_VALUE, atlantic);
       }
       
       
       //Getting common cells that can go into Pacific and Atlantic
       for(int i=0; i<row;i++) {
           for(int j=0; j<col; j++) {
               if (pacific[i][j] && atlantic[i][j]) {
                   res.add(Arrays.asList(i,j));
               }
           }
       }
       
       return res;
       
   }
    
    public void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean) {
        if (i<0 || i>=ocean.length || j<0 || j>=ocean[i].length) {return;}
        
        if(!(matrix[i][j] >= prev) || ocean[i][j]) {return;}
        ocean[i][j] = true;
        
        for(int[] d: dir) {
            dfs(matrix, i+d[0], j+d[1], matrix[i][j], ocean);
        }
        
        
    }
}