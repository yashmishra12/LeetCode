class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE-10);
        dp[0] = 0;
        
        for(int denom: coins) {
            for(int i=denom;i<dp.length; i++) {
                dp[i] = Math.min(dp[i], 1+dp[i-denom]);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE-10 ? -1 : dp[amount];
    }
}