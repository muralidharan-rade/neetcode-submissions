class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n < m) {
            return findMedian(nums1, nums2);
        }
        
        return findMedian(nums2, nums1);
    }

    private double findMedian(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int l = 0;
        int r = n;

        while(l <= r) {
            int c1 = l + (r - l) / 2;
            int c2 = (n+m)/2 - c1;

            int l1 = c1 >= 1 ? nums1[c1 - 1] : Integer.MIN_VALUE;
            int l2 = c2 >= 1 ? nums2[c2 - 1] : Integer.MIN_VALUE;
            int r1 = c1 < n ? nums1[c1] : Integer.MAX_VALUE;
            int r2 = c2 < m ? nums2[c2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if ((n+m) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l1 > r2) {
                r = c1 - 1;
            } else {
                l = c1 + 1;
            }
        }

        return -1;
    }
}
