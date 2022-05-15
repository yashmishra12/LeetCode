class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        
        for(int a: nums) {
            sum = Math.max(a, sum+a);
            res = Math.max(sum, res);
        }
        
        return res;
        
    }
}