class Solution {
    public int searchInsert(int[] nums, int target) {

        int n = nums.length;

        int s = 0;
        int e = n - 1;
        int ans = -1;

        if(target < nums[0]) {
            return 0;
        }

        if(target > nums[e]) {
            return n;
        }

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                s = mid + 1;
                ans = s;
            } else {
                e = mid - 1;
                ans = Math.max(ans, e);
            }
        }

        return ans;        
    }
}