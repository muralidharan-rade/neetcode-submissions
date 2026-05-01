class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyValue = Integer.MAX_VALUE;

        for (int i=0; i<prices.length; i++) {
            buyValue = Math.min(buyValue, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - buyValue);
        }

        return maxProfit;
    }
}
