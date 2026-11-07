class Solution {
    public int maxProfit(int[] prices) {
        int buyStock = prices[0];
        int profit = 0;
        int n = prices.length;

        for(int i=1 ; i<n ; i++) {
            if(prices[i] < buyStock) {
                buyStock = prices[i];
            } else {
                profit += prices[i] - buyStock;
                buyStock = prices[i];
            }
        }
        return profit;
    }
}