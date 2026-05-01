/**
 * 396. Rotate Function
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long total = 0;
        long current = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];
            current += (long) i * nums[i];
        }

        long best = current;

        for (int k = 1; k < n; k++) {
            current += total - (long) n * nums[n - k];
            best = Math.max(best, current);
        }

        return (int) best;
    }
}
