/**
 * 1855. Maximum Distance Between a Pair of Values
 * Time: O(n + m)
 * Space: O(1)
 */
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = 0;
        int maxDist = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                maxDist = Math.max(maxDist, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDist;
    }
}
