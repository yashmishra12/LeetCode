class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
              int row = arr.length-1;
        int col=0;
        
        while(row>=0 && col<arr[0].length) {
            int curNum = arr[row][col];
            if(curNum>target) {row--;} //upar jao if you are big; 
            else if(curNum<target) {col++;} //left jao if you are small. 
            else return true;
        }
        
        return false;
        
    }
}