class Solution {
    public int maxProfit(int[] prices) {
       if(prices.length<2 || prices==null) return 0;
        int maxProfit = 0;
        
        for(int i=0; i<prices.length-1; i++) {
            int bp = prices[i];
            int sp = prices[i+1];
            
            if(sp>bp) {
                maxProfit = maxProfit + (sp-bp);
            }
        }
        
        return maxProfit;
    }
}