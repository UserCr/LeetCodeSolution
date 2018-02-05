/**
多次买卖可以类比现实中的交易，只要在每个价格上升期都以最低价买入，最高价卖出，就一定可以获得最大利润。
**/

int maxProfit(int* prices, int pricesSize) {
    if(0 == pricesSize) return 0;
    
    int up_start = 0, sum = 0;
    for(int i = 1; i < pricesSize; ++i) {
        if(prices[i] < prices[i - 1]) {
            sum += (prices[i - 1] - prices[up_start]);
            up_start = i;
        }
    }
    if(prices[pricesSize - 1] >= prices[pricesSize - 2]) sum += (prices[pricesSize - 1] - prices[up_start]);
    
    return sum;
}
