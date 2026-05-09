class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return robb(nums, 0, dp);
    }

    private int robb(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }


        int robbed = robb(nums, idx+2, dp) + nums[idx];    
        int cool = robb(nums, idx+1, dp);


        dp[idx] = Math.max(robbed, cool);
        return dp[idx];
    }
}
