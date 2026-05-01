class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int len = Integer.MAX_VALUE;

        int[] pref = calculatePrefix(nums, n);

        int l=0;
        int r=0;

        if(pref[l] == target) {
            return 1;
        }

        int sum = pref[l];

        while(l<=r && r<n) {
            
            if(sum >= target) {
                len = Math.min(len, r-l+1);
                
                sum = pref[r] - pref[l];
                l++;
            } else {
                r++;
                if (r < n) {
                    sum = pref[r];
                }
            }
        }

        if (len == Integer.MAX_VALUE) {
            return 0;
        }

        return len;        
    }

    private int[] calculatePrefix(int[] nums, int n) {
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        return prefix;
    }
}