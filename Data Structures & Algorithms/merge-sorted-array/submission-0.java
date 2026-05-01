class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m;
        for(int num : nums2) {
            nums1[idx++] = num;
        }

        Arrays.sort(nums1);
    }
}