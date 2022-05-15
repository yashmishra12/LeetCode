class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int candidate = Integer.MIN_VALUE;
        
        for(int num: nums) {
            if (count==0) candidate = num;
            
            if (num==candidate) 
                count++;
            else 
                count--;
        }
        
        return candidate;
        
    }
}