/**
当更低价出现时，未来可能会有更高收益，所以要将最低价更新，但是有可能会出现2913这种组合，所以要记录最低价更新之前的最大利润。
**/

int maxProfit(int* prices, int pricesSize) {
    if(0 == pricesSize) return 0;
    
    int min = prices[0], max_profit = 0;
    for(int i = 1; i < pricesSize; ++i) {
        if(min > prices[i]) {
            min = prices[i];
        } else if(max_profit < prices[i] - min) {
            max_profit = prices[i] - min; 
        }
    }
    
    return max_profit;
}
