function maxProfit(prices: number[]): number {
    if(prices.length===1) {return 0}
    var maxProfit = 0;

    for(let i=0; i<prices.length-1; i++) {
        const buyPrice = prices[i];
        const sellPrice = prices[i+1];

        if(buyPrice<sellPrice) {
            maxProfit += (sellPrice - buyPrice);
        }
    }

    return maxProfit
};