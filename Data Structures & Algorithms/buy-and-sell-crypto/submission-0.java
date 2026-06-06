class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, current_profit = 0 , max_profit = 0;
        for (int i = 0; i < n; i++) {
            int purchased_neetcoin_price = prices[i];
            for (int j = i + 1; j < n; j++) {
                int current_purchasing_price = prices[j];
                 max_profit = Math.max(current_purchasing_price - purchased_neetcoin_price,max_profit);
    
            }
        }
        return max_profit;
    }
}
