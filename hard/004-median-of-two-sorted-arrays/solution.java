/**
 * 4. Median of Two Sorted Arrays
 * Time: O(log(min(m, n)))
 * Space: O(1)
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Binary search over the shorter array.
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int half = (m + n + 1) / 2;
        int lo = 0;
        int hi = m;

        while (lo <= hi) {
            int i = (lo + hi) / 2;       // elements taken from nums1
            int j = half - i;            // elements taken from nums2

            long left1 = i > 0 ? nums1[i - 1] : Long.MIN_VALUE;
            long right1 = i < m ? nums1[i] : Long.MAX_VALUE;
            long left2 = j > 0 ? nums2[j - 1] : Long.MIN_VALUE;
            long right2 = j < n ? nums2[j] : Long.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (((m + n) & 1) == 1) {
                    return Math.max(left1, left2);
                }
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                hi = i - 1;              // took too many from nums1
            } else {
                lo = i + 1;              // took too few from nums1
            }
        }

        return 0.0;
    }
}
