class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0 || prices==null) return 0;
        
        int[][] dp = new int[k+1][prices.length];
        int res=0;
        
        for(int i=1; i<dp.length; i++) {
            int curMax = Integer.MIN_VALUE;
            for(int j=1; j<dp[i].length; j++) {
                curMax = Math.max(curMax, dp[i-1][j-1] - prices[j-1]);
                dp[i][j] = Math.max(dp[i][j-1], curMax+prices[j]);
                
            }
        }
        
        return dp[k][prices.length-1];
    }
}