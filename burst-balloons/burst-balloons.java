class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        
        int[][] dp = new int[len][len];
        
        
        
        for(int gap=0; gap<len; gap++) {
            for(int i=0, j=gap; j<len; j++, i++) {
                
                int res = Integer.MIN_VALUE;
                
                for(int k=i; k<=j; k++) {
                    int left = (k==i) ? 0 : dp[i][k-1];
                    int right = (k==j) ? 0 : dp[k+1][j];
                    
                    int temp1 = (i==0) ? 1: nums[i-1];
                    int temp2 = (j==len-1) ? 1: nums[j+1];
                    
                    int curVal = temp1 * nums[k] * temp2;
                    
                    int totalVal = left+curVal+right;
                    if(res<totalVal)
                        res = totalVal;
                }
                
                dp[i][j] = res;
            }
        }
        
        return dp[0][len-1];
        
    }
}