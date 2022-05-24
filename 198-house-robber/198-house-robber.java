class Solution {
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        if ( n == 0) return 0;
        int[] res = new int[n+1];
        res[n] = 0;
        res[n - 1] = nums[n - 1];
        
        for (int i = n - 2; i >= 0; --i) {
            res[i] = Math.max(res[i + 1], res[i + 2] + nums[i]);
        }
        
        return res[0];
    }
}