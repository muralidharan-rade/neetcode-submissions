class Solution {
    int ans = 0;
    
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        climb(n, dp);

        return dp[n];
    }

    private int climb(int steps, int[] dp) {
        if(steps <= 1) {
            return dp[steps];
        }

        if(dp[steps] != -1) {
            return dp[steps];
        }

        dp[steps] = climb(steps-1, dp) + climb(steps-2, dp);
        return dp[steps];
    }
}
