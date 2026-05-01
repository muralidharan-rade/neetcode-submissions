class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n+n];

        int i = 0;
        for(int num : nums) {
            ans[i] = nums[i];
            ans[i+n] = nums[i];
            i++;
        }        

        return ans;
    }
}