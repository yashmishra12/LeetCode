class Solution {
    int[] arr;
    
    public Solution(int[] nums) {
        arr = nums;
    }
    
    public int[] reset() { return arr;}
    
    public int[] shuffle() {
        int[] temp = arr.clone(); //doesn't matter as we will shuffle this anyway
        
        for(int i=temp.length-1; i>=0; i--) {
            int idx = new Random().nextInt(i+1);
            
            int tmpVal = temp[i];
            temp[i] = temp[idx];
            temp[idx] = tmpVal;
        }
        
        return temp;
        

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */