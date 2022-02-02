class Solution {
    public int maxProfit(int[] prices) {
        int minYet = prices[0];
        
        int[] dp1 = new int[prices.length];
        
        for(int i=1; i<prices.length; i++) {
            int profit = prices[i] - minYet;
            dp1[i] = Math.max(profit, dp1[i-1]);
            
            minYet = Math.min(minYet, prices[i]);
        }
        
        
        int maxYet = prices[prices.length-1];
        
        int[] dp2 = new int[prices.length];
        
        for(int i=prices.length-2; i>=0; i--) {
            int profit = maxYet - prices[i];
            dp2[i] = Math.max(profit, dp2[i+1]);
            
            maxYet = Math.max(maxYet, prices[i]);
        }
        
        int res = 0;
        for(int i=0;i<prices.length;i++) {
            res = Math.max(res, dp1[i]+dp2[i]);
        }
        
        return res;
    }
}