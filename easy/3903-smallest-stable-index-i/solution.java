/**
 * 3903. Smallest Stable Index I
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int smallestStableIndex(int[] nums, int k) {
        int n = nums.length;

        // sufMin[i] = min(nums[i..n-1])
        int[] sufMin = new int[n];
        sufMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMin[i] = Math.min(nums[i], sufMin[i + 1]);
        }

        // Running prefix max; scanning left to right finds the smallest index.
        int prefMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prefMax = Math.max(prefMax, nums[i]);
            if (prefMax - sufMin[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}
