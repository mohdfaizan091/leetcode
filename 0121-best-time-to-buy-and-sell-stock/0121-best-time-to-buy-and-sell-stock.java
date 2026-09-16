class Solution {
    public int maxProfit(int[] prices) {
        int buyStock = Integer.MAX_VALUE;
        int n = prices.length;
        int idx = -1;
        int profit = 0;
        for(int i=0 ; i<n ; i++){
            if(prices[i] < buyStock){
                buyStock = prices[i];
            } else {
                profit = Math.max(profit , prices[i]-buyStock);
            }
        }
        return profit;
    }
}