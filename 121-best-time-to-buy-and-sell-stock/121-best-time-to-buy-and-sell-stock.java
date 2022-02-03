class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int maxProfit = 0;
        int buyingPrice = prices[0];
        
        for(int i=0; i<prices.length; i++) {
            buyingPrice = Math.min(buyingPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-buyingPrice);
        }
        
        return maxProfit;
    }
}