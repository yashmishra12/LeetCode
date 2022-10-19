// class Solution {
//     public int[][] transpose(int[][] matrix) {
//         int n = matrix.length, c = matrix[0].length;
//         int[][] ans = new int[matrix.length][c];
		
//         for(int i=0; i<n; i++){
// 			for(int j=0; j<c; j++) {
// 				ans[j][i] = matrix[i][j];
// 			}
// 		}
        
//         return ans;

//     }
// }

class Solution {
    public int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;
    }
}