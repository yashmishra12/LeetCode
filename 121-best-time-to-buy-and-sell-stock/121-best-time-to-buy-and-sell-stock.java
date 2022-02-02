class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyingPrice = Integer.MAX_VALUE;
        
        for(int i=0; i<prices.length; i++) {
            buyingPrice = Math.min(buyingPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-buyingPrice);
        }
        
        return maxProfit;
    }
}