class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        int[][] dirs = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        
        int startRow = entrance[0], startCol = entrance[1];
        maze[startRow][startCol] = '+'; //mark as visited;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startRow, startCol,0});
        
        while(!q.isEmpty()) {
            int[] curState = q.poll();
            int curRow = curState[0];
            int curCol = curState[1];
            int curDis = curState[2];
            
            for(int[] dir: dirs){
                int nxtRow = curRow+dir[0];
                int nxtCol = curCol+dir[1];
                
                if(withinRangeAndEmpty(nxtRow, nxtCol, maze)) {
                     if(onEdge(nxtRow, nxtCol, maze)) {
                         return curDis+1;
                    }
                    
                    maze[nxtRow][nxtCol] = '+';
                    q.offer(new int[]{nxtRow, nxtCol, curDis+1});   
                    
                }
                 
                
            }
        }
        return -1;
    }
    
    public static boolean withinRangeAndEmpty(int nxtRow, int nxtCol, char[][] maze) {
        if(nxtRow>=0 && nxtRow<maze.length && nxtCol>=0 && nxtCol<maze[0].length){
            if(maze[nxtRow][nxtCol]=='.'){
                return true;
            }
        }
        return false;
    }
    public static boolean onEdge(int r, int c, char[][]arr) {
        if(r==0||r==arr.length-1 ||c==0||c==arr[0].length-1) {
            return true;
        }
        return false;
    }
    
    
}