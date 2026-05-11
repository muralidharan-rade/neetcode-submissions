class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        return Math.min(climb(cost, 0, dp), climb(cost, 1, dp));
    }

    private int climb(int[] cost, int idx, int[] dp) {
        if(idx >= cost.length) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int c1 = climb(cost, idx + 2, dp);
        int c2 = climb(cost, idx + 1, dp);

        dp[idx] = cost[idx] + Math.min(c1, c2);
        return dp[idx];
    }
}
