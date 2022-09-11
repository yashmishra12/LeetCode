class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length<3) {return false; }
        
        Stack<Integer> st = new Stack<>();
        int secondHighest = Integer.MIN_VALUE;
        
        for(int i = nums.length-1; i>=0; i--) {
            
            if (nums[i] < secondHighest) {
                return true;
            }
            
            while(!st.isEmpty() && st.peek()<nums[i] ) {
                secondHighest = Math.max(secondHighest, st.pop());
     
            }
             st.push(nums[i]);
            
            
        }
        
        return false;
                
    }
}

