class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length; 
        int temp = n;
        int val = 0;

        for(int i=1; i<=n; i++) {
            val = val ^ i;
        }

        for(int i=0; i<n; i++) {
            val = val ^ nums[i];
        }

        return val;
    }
}
