class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int maxPathLength = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                int curPathLength = dfs(matrix, dp, i, j);
                maxPathLength = Math.max(curPathLength, maxPathLength);
            }
        }
        
        return maxPathLength;
        
    }
    
    public static int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if(dp[i][j]>0) return dp[i][j];
        
        int max=0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int[] d: dirs) {
            int newX = i+d[0];
            int newY = j+d[1];
            
            if(newX>=0 && newY>=0 && newX<dp.length && newY<dp[i].length && matrix[newX][newY]>matrix[i][j]) {
                max = Math.max(max, dfs(matrix, dp, newX, newY));
            }
        }
        dp[i][j]=max+1;
        
        return max+1;
    }
}