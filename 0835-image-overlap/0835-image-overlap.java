class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int max = 0;
        
        for(int rowOffSet=-img1.length+1; rowOffSet<img1.length; rowOffSet++) {
            for(int colOffSet=-img1.length+1; colOffSet<img1.length; colOffSet++) {
                max = Math.max(max, shiftAndCount(rowOffSet, colOffSet, img1, img2));
            }
        }
        
        return max;
    }
    
    public int shiftAndCount(int rowOffSet, int colOffSet, int[][]A, int[][] B) {
        int count = 0;
        
        for(int row=0; row<A.length; row++) {
            for(int col=0; col<A[row].length;col++){
                int finalRow = row + rowOffSet;
                int finalCol = col + colOffSet;
                
                if( finalRow<0 || finalRow>=A.length || finalCol<0 || finalCol>=A.length) {
                    continue;
                }
                
                if(A[row][col] + B[finalRow][finalCol]==2) {
                    count++;
                }
            }
        }
        
       return count;
    }
}