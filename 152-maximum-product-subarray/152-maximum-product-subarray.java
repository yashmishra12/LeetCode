class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        
        int max=nums[0];
        int min=nums[0]; //handles negative numbers. 
        int res = max;
        
        for(int i=1; i<nums.length; i++) {
            int curr = nums[i];
            
            int posMax = max*curr;
            int negMax = min*curr; //-ve x -ve ---> +ve
            
            int tmpMax = Math.max(curr, Math.max(posMax, negMax));
            min = Math.min(curr, Math.min(posMax, negMax));
            
            max = tmpMax;
            
            res = Math.max(max, res);
        }
        
        return res;
        
    }
}