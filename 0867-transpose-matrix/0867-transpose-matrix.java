class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int c = matrix[0].length;
        
        int[][] ans = new int[c][n];
		
        for(int i=0; i<n; i++){
			for(int j=0; j<c; j++) {
				ans[j][i] = matrix[i][j];
			}
		}
        
        return ans;

    }
}
