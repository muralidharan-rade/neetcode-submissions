class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        int n = nums.length; 

        int s = 0;
        int e = n - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if(nums[mid] >= nums[0]) {
                s = mid + 1;
            } else {
                ans = Math.min(nums[mid], ans);
                e = mid - 1;
            }
        }

        return ans;        
    }
}
