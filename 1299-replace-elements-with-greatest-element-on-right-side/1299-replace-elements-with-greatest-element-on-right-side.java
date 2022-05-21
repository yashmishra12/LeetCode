class Solution {
    public int[] replaceElements(int[] arr) {
        
        int greatestTillNow = arr[arr.length-1];
        arr[arr.length-1] = -1;
        
        for(int i=arr.length-2; i>=0; i--) {
            int curNum = arr[i]; 
            arr[i] = greatestTillNow;
            
            if(curNum>greatestTillNow) {
                greatestTillNow = curNum;
            }
        }
        
        return arr;
        
    }
}