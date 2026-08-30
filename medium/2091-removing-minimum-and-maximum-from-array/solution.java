/**
 * 2091. Removing Minimum and Maximum From Array
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int lo = Math.min(minIdx, maxIdx);
        int hi = Math.max(minIdx, maxIdx);

        int bothFront = hi + 1;
        int bothBack = n - lo;
        int split = (lo + 1) + (n - hi);
        return Math.min(bothFront, Math.min(bothBack, split));
    }
}
