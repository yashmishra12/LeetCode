class Solution {
    int[] arr;
    int[] orig; 
    
    public Solution(int[] nums) {
        arr = nums;
        orig = nums.clone();
    }
    
    public int[] reset() {
        return orig;
    }
    
    public int[] shuffle() {
        ArrayList<Integer> cs = new ArrayList<>();
        for(int a: arr) {cs.add(a);}
        Collections.shuffle(cs);
        
        int[] temp = new int[cs.size()];
        
        for(int i=0; i<cs.size();i++) {
            temp[i] = cs.get(i);
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