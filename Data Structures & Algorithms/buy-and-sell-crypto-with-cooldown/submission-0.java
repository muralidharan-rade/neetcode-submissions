class Solution {
    public int maxProfit(int[] prices) {
        int canBuy = 0; //0 buy - 1 sell 
        int n = prices.length;
        int[][] dp = new int[n][2];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        return dfs(0, prices, dp, canBuy);
    }

    private int dfs(int idx, int[] prices, int[][] dp, int canBuy) {
        if(idx >= prices.length){
            return 0;
        }

        if(dp[idx][canBuy] != Integer.MAX_VALUE) {
            return dp[idx][canBuy];
        }

        if(canBuy == 0) {
            int buy = dfs(idx + 1, prices, dp, canBuy + 1) - prices[idx];
            int cooldown = dfs(idx+1, prices, dp, canBuy);
            int p = Math.max(buy, cooldown);
            dp[idx][canBuy] = p;
        } else {
            int sell = dfs(idx + 2, prices, dp, canBuy - 1) + prices[idx];
            int cooldown = dfs(idx+1, prices, dp, canBuy);
            int p = Math.max(sell, cooldown);
            dp[idx][canBuy] = p;
        }

        return dp[idx][canBuy];
    }
}
