class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        for(int denom: coins) {
            for(int i=denom; i<dp.length;i++) {
                dp[i] = dp[i]+dp[i-denom];
            }    
        }
        
        return dp[amount];
    }
}