class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int s = 0;
        int e = n - 1;

        while(s <= e) {
            int mid = s + (e - s) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(target >= nums[0]) { //in p1
                if(nums[mid] >= nums[0]) { // in p1
                    if(nums[mid] < target) {
                        s = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                } else { // in p2
                    e = mid - 1;
                }
            } else { // in p2
                if (nums[mid] >= nums[0]) { // in p1
                    s = mid + 1;
                } else { // in p2
                    if (nums[mid] > target) {
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                }
            }
        }

        return -1;
    }
}
