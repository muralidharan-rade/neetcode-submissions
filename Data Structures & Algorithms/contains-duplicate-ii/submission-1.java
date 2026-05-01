class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 1 && k == 1) {
            return false;
        }
        
        HashSet<Integer> hs = new HashSet<>();
        int i = 0;
        int j = 0;

        while(j <= k) {
            if(!hs.add(nums[j])) {
                return true;
            }
            j++;
        }

        while(i <= nums.length - k && j < nums.length) {
            hs.remove(nums[i]);

            if(!hs.add(nums[j])) {
                return true;
            }
            i++;
            j++;
        }

        return false;
    }
}